package com.example.dataStructure.chap05;

public class TheTowerOfHanoi {
    //no 개의 원반을 x 번 기둥에서 y 번 기둥으로 옮김
    public static void move(int no, int x, int y) {
        if ( no > 1 )
            move(no-1, x, 6-x-y);

        System.out.println( no + " : " + x + " -> " + y );

        if ( no > 1 )
            move( no - 1, 6-x-y, y );
    }

    public static void main(String[] args) {
        int no = 3;
        System.out.println( "하노이의 탑\n원반 갯수 : " + no);
        move( no, 1, 3 );
    }
}
