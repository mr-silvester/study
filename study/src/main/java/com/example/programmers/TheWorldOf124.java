package com.example.programmers;

public class TheWorldOf124 {
    /**
     * 124나라
     * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
     * 124 나라에는 자연수만 존재합니다.
     * 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
     */
    static String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        int num = n;

        while(num > 0){
            int remainder = num % 3;
            num /= 3;

            if(remainder == 0) num--;

            answer = numbers[remainder] + answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        for ( int i = 1; i < 20; i++ )
            System.out.println("자연수 n이 " + i + "일 때 결과 : " + solution(i));
    }
}
