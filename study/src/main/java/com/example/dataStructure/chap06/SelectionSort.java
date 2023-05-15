package com.example.dataStructure.chap06;

import java.util.Arrays;
import java.util.Set;

public class SelectionSort {
    private static void swap(int[] a, int x, int y) {
        int temp;
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static int[] selectionSort(int[] a) {
        for ( int i = 0; i < a.length-1; i++ ) {
            int min = i;
            for ( int j = i + 1; j < a.length; j++ )
                if ( a[min] > a[j] )
                    min = j;
            swap(a, min, i);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = { 3, 4, 2, 3, 1 };
        System.out.println(Arrays.toString(selectionSort(a)));
    }
}
