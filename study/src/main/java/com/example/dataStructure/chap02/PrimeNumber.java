package org.example.chap02;

import java.util.Arrays;

public class PrimeNumber {
    static int[] getPrimesVer1(int n) {
        int[] primes = new int[n/2];
        int ptr = 0;
        int counter = 0;

        primes[ptr++] = 2;
        primes[ptr++] = 3;

        for ( int i = 5; i <= n; i+=2 ) {
            int j;
            for ( j = 1; j < ptr; j++ ) {
                counter++;
                if ( i % primes[j] == 0 ) {
                    break;
                }
            }
            if ( j == ptr )
                primes[ptr++] = i;
        }
        System.out.println("counter = " + counter);
        return primes;
    }

    static int[] getPrimesVer2(int n) {
        int[] primes = new int[n/2];
        int ptr = 0;
        int counter = 0;

        primes[ptr++] = 2;
        primes[ptr++] = 3;

        for ( int i = 5; i <= n; i+=2 ) {
            int j;
            boolean flag = false;
            for (j = 1; primes[j]*primes[j] <= i; j++) {
                counter += 2;
                if ( i % primes[j] == 0 ) {
                    flag = true;
                    break;
                }
            }
            if ( !flag ) {
                counter++;
                primes[ptr++] = i;
            }
        }
        System.out.println("counter = " + counter);
        return primes;
    }

    public static void main(String[] args) {
        System.out.println("Ver1 : " + Arrays.toString(getPrimesVer1(1000)));
        System.out.println("Ver2 : " + Arrays.toString(getPrimesVer2(1000)));
    }
}
