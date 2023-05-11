package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem003 {
    /** 구간 합 구하기
     *  1. 숫자의 갯수, 질의의 갯수 입력 받기
     *  2. 합 배열 생성하기
     *  3. 질의 마다 구간합 출력
     */
    public static void main(String[] args) throws IOException {
        //Given
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(b.readLine());

        int suNo = Integer.parseInt(s.nextToken());
        int quizNo = Integer.parseInt(s.nextToken());
        long[] S = new long[suNo + 1];
        s = new StringTokenizer(b.readLine());
        for ( int i = 1; i <= suNo; i++ )
            S[i] = S[ i-1 ] + Integer.parseInt(s.nextToken());

        for ( int n = 0; n < quizNo; n++ ) {
            s = new StringTokenizer(b.readLine());
            int i = Integer.parseInt(s.nextToken());
            int j = Integer.parseInt(s.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
    }
}
