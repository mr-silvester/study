package com.example.dataStructure.chap02;

import java.util.Arrays;

public class ArrayEqual {
    static int[] genArray(int n) {
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = i;
        }
        return x;
    }

    static boolean equals(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if ( a[i] != b[i] )
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = genArray(5);
        int[] b = genArray(4);

        System.out.println("Array a and b are " + (equals(a, b)?"equal":"not equal"));
    }
}
