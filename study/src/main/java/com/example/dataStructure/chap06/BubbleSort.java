package com.example.dataStructure.chap06;

import java.util.Arrays;

public class BubbleSort {
    public static int x = 0;
    private static void swap(int[] a, int x, int y) {
        int temp;
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    public static int[] bubbleSortVer1(int[] a) {

        for ( int j = 0; j < a.length-1; j++ ) {
            for (int i = 1; i < a.length - j; i++) {
                if (a[i] < a[i - 1]) {
                    swap(a, i, i-1);
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {6, 4, 3, 7, 1, 9, 8};
        System.out.println(Arrays.toString(bubbleSortVer1(a)) + x);
    }
}
