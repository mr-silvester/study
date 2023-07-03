package com.example.programmers;

public class LookGoodNum {
    public int solution(String s) {
        int answer = -1;
        for ( int i = 0; i < s.length()-2; i++ ) {
            if ( s.charAt(i)==s.charAt(i+1)&&s.charAt(i+1)==s.charAt(i+2) ) {
                answer = Math.max(answer, Integer.parseInt(s.substring(i, i + 3)));
                i = i+3;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        LookGoodNum d = new LookGoodNum();
        String s = "115153518700095";
        System.out.println(d.solution(s));
    }
}