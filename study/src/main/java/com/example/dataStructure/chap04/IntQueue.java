package com.example.dataStructure.chap04;

import java.util.Scanner;

public class IntQueue {
    private int max;    //배열의 길이(최대 인덱스 : max - 1
    private int front;  //처음 요소의 커서
    private int rear;   //마지막 요소의 커서
    private int num;    //현재 데이터 수
    private int[] que;  //큐 본체

    public IntQueue(int capacity) {
        max = capacity;
        front = rear = num = 0;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public int enqueue(int x) throws OverflowIntQueueException {
        if ( num >= max )
            throw new OverflowIntQueueException();
        que[rear++] = x;
        num++;
        if ( rear == max )
            rear = 0;
        return x;
    }

    public int dequeue() throws EmptyIntQueueException {
        if ( num <= 0 )
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if ( front == max )
            front = 0;
        return x;
    }

    public int peek() throws IntStack.EmptyIntStackException {
        if ( num <= 0 )
            throw new EmptyIntQueueException();
        return que[front];
    }

    public int indexOf(int x) {
        for ( int i = 0; i < num; i++ ) {
            int idx = ( i + front ) % max;
            if ( que[idx] == x )
                return idx;
        }
        return -1;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if ( num <= 0 )
            System.out.println("큐가 비어있습니다.");
        else {
            for ( int i = 0; i < num; i++ ) {
                System.out.print(que[(i + front ) % max] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        IntQueue q = new IntQueue(64);
        Scanner stdIn = new Scanner(System.in);

        while (true) {
            System.out.println("현재 데이터 수 : " + q.size() + " / " + q.capacity());
            System.out.print("(1)인큐  (2)디큐  (3)피크  (4)덤프  (5)검색  (0)종료 : ");

            int menu = stdIn.nextInt();
            if ( menu == 0 ) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        q.enqueue(x);
                    } catch (OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                case 2:
                    try {
                        x = q.dequeue();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (EmptyIntQueueException e) {
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;
                case 3:
                    try {
                        x = q.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (EmptyIntQueueException e) {
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;
                case 4:
                    q.dump();
                    break;
                case 5:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    int result = q.indexOf(x);
                    System.out.println(result==-1?"해당 값을 찾지 못하였습니다.":"해당 값은 " + result + "번 인덱스에 있습니다.");
            }
        }
    }
}
