package com.example.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class KakaoMbti {
    public static String solution(String[] survey, int[] choices) {
        Map<String, Integer> surveyScore = getScore(survey, choices);
        String answer = "";

        if ( surveyScore.get("R") >= surveyScore.get("T") )
            answer += "R";
        else
            answer += "T";

        if ( surveyScore.get("C") >= surveyScore.get("F") )
            answer += "C";
        else
            answer += "F";

        if ( surveyScore.get("J") >= surveyScore.get("M") )
            answer += "J";
        else
            answer += "M";

        if ( surveyScore.get("A") >= surveyScore.get("N") )
            answer += "A";
        else
            answer += "N";

        return answer;
    }

    private static Map<String, Integer> getScore(String[] survey, int[] choices) {
        //유형 별 점수 획득량 저장
        //선택지-4의 값이 음수인 경우 첫번째 유형에 양수로 변환하여 그 점수를 더하고, 양수인 경우 두번째 유형에 그 점수를 더한다.
        Map<String, Integer> surveyScore = new HashMap<>();
        surveyScore.put("R", 0);
        surveyScore.put("T", 0);
        surveyScore.put("C", 0);
        surveyScore.put("F", 0);
        surveyScore.put("J", 0);
        surveyScore.put("M", 0);
        surveyScore.put("A", 0);
        surveyScore.put("N", 0);

        for ( int i = 0; i < survey.length; i++ ) {
            int score = choices[i] - 4;
            String key;
            int value;
            if ( score < 0 ) {
                key = survey[i].substring(0, 1);
                value = surveyScore.get(key) - score;
                surveyScore.put(key, value);
            }
            if ( score > 0 ) {
                key = survey[i].substring(1, 2);
                value = surveyScore.get(key) + score;
                surveyScore.put(key, value);
            }
        }

        return surveyScore;
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println("result : " + solution(survey, choices));
    }
}
