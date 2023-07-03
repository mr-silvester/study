package com.example.programmers.level2;

public class Delivery {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        Delivery d = new Delivery();
        System.out.println("result : " + d.solution( cap, n, deliveries, pickups ));
    }
}
