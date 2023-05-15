package com.example.dataStructure.chap06;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSort(int[] a) {
        for ( int i = 1; i < a.length; i++ ) {
            int j;
            int tmp = a[i];
            for ( j = i; j > 0 && a[j - 1] > tmp; j-- ) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = { 6, 4, 1, 7, 3, 9, 8};
        System.out.println(Arrays.toString(insertionSort(a)));
    }
}
