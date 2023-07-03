package com.example.programmers.level1;

public class Keypad {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        hand = hand.substring(0, 1).toUpperCase();
        int l = 10;
        int r = 12;
        for ( int i = 0; i < numbers.length; i++ ) {
            if ( numbers[i] == 0 )
                numbers[i] = 11;
            if ( numbers[i] % 3 == 1 ) {
                answer.append("L");
                l = numbers[i];
            } else if ( numbers[i] % 3 == 0 ) {
                answer.append("R");
                r = numbers[i];
            } else {
                if ( getDistance(l, numbers[i]) < getDistance(r, numbers[i]) ) {
                    answer.append("L");
                    l = numbers[i];
                } else if ( getDistance(l, numbers[i]) > getDistance(r, numbers[i]) ) {
                    answer.append("R");
                    r = numbers[i];
                } else {
                    answer.append(hand);
                    if (hand.equals("L"))
                        l = numbers[i];
                    else
                        r = numbers[i];
                }
            }
        }
        return answer.toString();
    }

    public int getDistance(int a, int b) {
        int diff = a - b;
        if ( diff < 0 )
            diff *= -1;
        return diff / 3 + diff % 3  ;
    }

    public static void main(String[] args) {
        Keypad s = new Keypad();
        int[] numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
        String hand = "left";
        System.out.println("result : " + s.solution( numbers, hand ));
    }
}
