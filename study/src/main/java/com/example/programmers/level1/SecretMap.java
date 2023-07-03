package com.example.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        // 나누기
        for ( int j = 0; j < n; j++ ) {
            // 세로줄
            String line = "";
            int num1 = arr1[j];
            int num2 = arr2[j];
            for ( int i = 0; i < n; i++  ) {
                // 가로줄
                if ( ( num1 % 2 == 1 ) || ( num2 % 2 == 1 ) ) {
                    line = "#" + line;
                } else {
                    line = " " + line;
                }
                num1 /= 2;
                num2 /= 2;
            }
            System.out.println(line);
            answer[j] = line;
        }

        return answer;

        /*
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println(arr1[i] | arr2[i]);
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            System.out.println(result[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
        */
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = { 9, 20, 28, 18, 11 };
        int[] arr2 = { 30, 1, 21, 17, 28 };
        SecretMap s = new SecretMap();
        System.out.println("result : " + Arrays.toString(s.solution( n, arr1, arr2 )));
    }
}
