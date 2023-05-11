package com.example.algorithm;

import java.util.Scanner;

public class Problem002 {
    /** 조작된 평균 구하기
     * 1. 변수 N에 과목의 수 입력 받기
     * 2. N개의 과목 점수를 입력 받고 입력 받은 점수로 최대값 갱신, 그 후 변수 sum 에 합산
     * 3. 점수들의 합을 최대값으로 나누고 100을 곱하고 N으로 나눈다.
     * 4. 출력
     */
    public static void main(String[] args) {
        //Given
        Scanner s = new Scanner(System.in);

        long sum = 0;
        long max = 0;

        int N = s.nextInt();
        for ( int i = 0; i < N; i++ ) {
            int score = s.nextInt();
            if ( max < score )
                max = score;
            sum += score;
        }

        System.out.println("result : " + (( sum / max ) * 100.0 ) / N);
    }
}
