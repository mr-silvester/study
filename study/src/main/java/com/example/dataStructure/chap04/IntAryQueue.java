package com.example.dataStructure.chap04;

public class IntAryQueue {
    private int max;
    private int num;
    private int[] que;

    public IntAryQueue(int capacity) {
        max = capacity;
        int num = 0;
        que = new int[max];
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
        return que[num++] = x;
    }

    public int dequeue() throws EmptyIntQueueException {
        if ( num <= 0 )
            throw new EmptyIntQueueException();
        int temp = que[0];
        for ( int i = 1; i < num; i++ ) {
            que[i-1] = que[i];
        }
        num--;
        return temp;
    }

    public static void main(String[] args) {
        IntAryQueue q = new IntAryQueue(5);
    }
}
