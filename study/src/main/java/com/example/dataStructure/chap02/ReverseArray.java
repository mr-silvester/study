package com.example.dataStructure.chap02;

import java.util.Arrays;

public class ReverseArray {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void reverse(int[] a) {
        for (int i = 0; i < a.length/2; i++) {
            swap(a, i, a.length-i-1);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[9];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println("Before : " + Arrays.toString(a));
        reverse(a);
        System.out.println("After : " + Arrays.toString(a));
    }
}