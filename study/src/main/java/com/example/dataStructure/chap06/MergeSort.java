package com.example.dataStructure.chap06;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] a) {
        mergeSort(a, new int[a.length],0, a.length - 1);
    }
    private static void merge(int[] a, int[] tmp, int start, int mid, int end) {
        int ptr = 0;
        for ( int i = start; i <= end; i++ )
            tmp[i] = a[i];
        int ptr1 = start;
        int ptr2 = mid + 1;
        int idx = start;

        while ( ptr1 <= mid && ptr2 <= end ) {
            if (tmp[ptr1] <= tmp[ptr2]) {
                a[idx] = tmp[ptr1];
                ptr1++;
            } else {
                a[idx] = tmp[ptr2];
                ptr2++;
            }
            idx++;
        }
        for ( int i = 0; i <= mid - ptr1; i++ ) {
            a[idx + i] = tmp[ptr1 + i];
        }
    }
    private static void mergeSort(int[] a, int[] tmp, int start, int end) {
        if ( start < end ) {
            int mid = (start + end) / 2;
            mergeSort(a, tmp, start, mid);
            mergeSort(a, tmp, mid+1, end);
            merge(a, tmp, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] a = { 8, 1, 4, 2, 7, 6, 3, 5 };
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
