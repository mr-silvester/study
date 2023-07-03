package com.example.programmers.level1;

import java.util.*;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] a = new int[N + 2];
        int[] b = new int[N + 2];
        double[] rate = new double[N + 2];

        for (int stage : stages) {
            // 스테이지마다 현재 있는 인원 수를 배열에 저장
            a[stage] += 1;
        }
        // failure rate = a / a + b, a : n번 스테이지에 도착한 사람 수, b : n번 이상의 스테이지에 있는 사람 수
        // 0번 인덱스는 비워두고 1번부터 시작, N+1번 스테이지 도착자까지 고려하여 N + 2.
        b[N + 1] = a[N + 1];
        for ( int i = N; i >= 1; i--  ) {
            b[i] = ( a[i] + b[i + 1] );
            if ( b[i] == 0 ) {
                rate[i] = 0;
                continue;
            }
            rate[i] = ((double) a[i]) / ((double) b[i]);
        }

        Map<Integer, Double> map = new HashMap<>();
        for ( int i = 1; i <= N; i++  ) {
            map.put(i, rate[i]);
        }

        List<Integer> result = new ArrayList<>(map.keySet());
        result.sort((i1, i2) -> map.get(i2).compareTo(map.get(i1)));

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int N = 4;
        int[] stages = { 3, 3, 3, 3, 3 };
        FailureRate s = new FailureRate();
        System.out.println("result : " + Arrays.toString(s.solution(N, stages)));
    }
}
