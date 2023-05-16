package com.example.dataStructure.chap06;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }
    public static void mergeSort(int[] a, int start, int end) {

    }

    public static void main(String[] args) {
        int[] a = { 8, 1, 4, 2, 7, 6, 3, 5 };
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
