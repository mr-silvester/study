package org.example.chap03;

public class SeqSearch {
    static int seqSearch(int[] a, int n) {
        for ( int i = 0; i < a.length; i++ ) {
            if ( a[i] == n )
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i+1;
        }

        int result = seqSearch(a, 18);
        System.out.print(result==-1?"the value of the key cannot be found":"index of the key is " + result);
    }
}
