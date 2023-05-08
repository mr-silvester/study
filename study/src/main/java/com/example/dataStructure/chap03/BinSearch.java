package org.example.chap03;

public class BinSearch {
    static int binSearch(int[] a, int n) {
        int pl = 0;
        int pr = a.length-1;
        int pc = a.length/2;

        while(pl <= pr) {
            if (a[pc] == n) {
                return pc;
            } else if (a[pc] < n) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
            pc = (pl + pr) / 2;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = new int[9];
        for ( int i = 0; i < a.length; i++ ) {
            a[i] = i*(i+1);
        }
        int result = binSearch(a, 56);
        System.out.print(result==-1?"the value of the key cannot be found":"index of the key is " + result);
    }
}
