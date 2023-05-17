package com.example.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PersonalInfo {
    /** 개인정보 수집 유효 기간
     * 고객의 약관 동의를 얻어서 수집된 1~n 번으로 분류되는 개인정보 n개가 있습니다.
     * 약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다.
     * 당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다.
     * 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.
     * 예를 들어, A라는 약관의 유효기간이 12 달이고, 2021년 1월 5일에 수집된 개인정보가 A 약관으로 수집되었다면
     * 해당 개인정보는 2022년 1월 4일까지 보관 가능하며 2022년 1월 5일부터 파기해야 할 개인정보입니다.
     * 당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.
     * 모든 달은 28일까지 있다고 가정합니다.
     * */
    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length + 1];

        //오늘 날짜를 일수로 변환
        int daysToday = Integer.parseInt(today.substring(0, 4)) * 28 * 12
                + Integer.parseInt(today.substring(5, 7)) * 28
                + Integer.parseInt(today.substring(8, 10));
        System.out.println("today : " + daysToday);

        //약관 종류 별 기간 매핑
        Map<Character, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            char key = term.charAt(0);
            int value = Integer.parseInt(term.substring(2));
            termsMap.put(key, value * 28);
        }
        System.out.println(termsMap);

        //약관 별 정보수집 일자 일수로 변경
        int ptr = 0;
        for ( int i = 0; i < privacies.length; i++ ) {
            String privacy = privacies[i];
            int daysPrivacy = Integer.parseInt(privacy.substring(0, 4)) * 12 * 28
                    + Integer.parseInt(privacy.substring(5, 7)) * 28
                    + Integer.parseInt(privacy.substring(8, 10));
            char key = privacy.charAt(11);
            if ( daysPrivacy + termsMap.get(key) - 1 < daysToday ) {
                answer[ptr++] = i + 1;
            }
        }
        System.out.println(Arrays.toString(answer));

        int a = 0;
        for ( int i = 0; answer[i] != 0; i++ ) {
            a++;
        }
        int[] arr = new int[a];
        System.arraycopy(answer, 0, arr, 0, arr.length);

        return arr;
    }

    public static void main(String[] args) {
         String today = "2022.01.01";
         String[] terms = {"Z 3", "D 5"};
         String[] privacies = {"2019.08.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

         System.out.println("result : " + Arrays.toString(solution(today, terms, privacies)));
    }
}
