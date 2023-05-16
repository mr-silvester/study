package com.example.dataStructure.chap06;

import java.util.Arrays;

public class QuickSort {
    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
    private static int partition(int[] a, int l, int r) {
        int p = a[( l + r ) / 2];
        while ( l <= r ) {
            while ( a[l] < p ) l++;
            while ( a[r] > p ) r--;
            if ( l <= r ) {
                swap(a, l, r);
                r--;
                l++;
            }
        }
        return l;
    }
    public static void quickSort(int[] a, int l, int r) {
        int p = partition(a, l, r);
        if (l < p - 1)
            quickSort(a, l, p - 1);
        if ( p + 1 < r )
            quickSort(a, p + 1, r);
    }

    public static void main(String[] args) {
        int[] a = { 8, 1, 4, 2, 7, 6, 3, 5 };
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
