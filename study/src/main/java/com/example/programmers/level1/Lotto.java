package com.example.programmers.level1;

import java.util.Arrays;

public class Lotto {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int count = 0;
        int zero = 0;
        for (int num : lottos) {
            if ( num == 0 )
                zero++;
            for (int winNum : win_nums) {
                if (num == winNum)
                    count++;
            }
        }
        answer[0] = 7 - count - zero;
        if ( answer[0] >= 7 )
            answer[0] = 6;
        answer[1] = 7 - count;
        if ( answer[1] >= 7 )
            answer[1] = 6;

        return answer;
    }
    public static void main(String[] args) {
        int[] lottos = {11, 12, 15, 14, 16, 13};
        int[] win_nums = {1, 2, 3, 4, 5, 6};
        System.out.println("result : " + Arrays.toString(solution(lottos, win_nums)));
    }
}
