package com.example.algorithm;

public class Problem001 {
    /** 숫자의 합 구하기
     *  1. String 형태로 주어진 문자열을 char[] 형태로 변환한다(toCharArray 메서드 사용).
     *  2. char 의 각 인덱스에 해당하는 문자를 정수형으로 변환하여 합산한다(반복문 사용).
     *  3. 결과를 반환한다.
     */
    public static void main(String[] args) {
        String sNum = "10987654321";

        int sum = 0;
        char[] cNum = sNum.toCharArray();
        for ( char c : cNum ) {
            sum += ( c - '0' );
        }

        int expected = 46;
        int result = sum;

        System.out.println(result==expected?"결과 값이 일치합니다.":"결과 값이 일치하지 않습니다." +
                "\nexpected : " + expected +
                "\nbut was : " + result);
    }
}
