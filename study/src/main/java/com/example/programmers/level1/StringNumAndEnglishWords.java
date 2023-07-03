package com.example.programmers.level1;

public class StringNumAndEnglishWords {
    public int solution(String s) {
        // 파싱 라이브러리 인덱스 = 숫자
        String[] lib = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int answer = 0;
        //int i = 0;
        for ( int i = 0; i < lib.length; i++ ) {
            s = s.replaceAll(lib[i], Integer.toString(i));
        }
        System.out.println(s);
        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        String str = "one4seveneight";
        StringNumAndEnglishWords s = new StringNumAndEnglishWords();
        System.out.println("result : " + s.solution( str ));
    }
}
