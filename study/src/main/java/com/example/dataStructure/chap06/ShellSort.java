package com.example.dataStructure.chap06;

import java.util.Arrays;

public class ShellSort {
    public static int[] shellSort(int[] a) {
        int h;
        for ( h = 1; h < a.length / 9; h = h * 3 + 1 );

        for ( ; h > 0; h /= 2 ) {
            for ( int i = h; i < a.length; i++ ) {
                int j;
                int tmp = a[i];
                for ( j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = tmp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = { 8, 1, 4, 2, 7, 6, 3, 5 };
        System.out.println(Arrays.toString(shellSort(a)));
    }
}
