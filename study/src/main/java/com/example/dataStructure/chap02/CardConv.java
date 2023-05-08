package org.example.chap02;

public class CardConv {
    static String cardConv(int dex, int x) {
        String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUXYZ";
        StringBuilder result = new StringBuilder();
        while(dex != 0) {
            result.insert(0, dChar.charAt(dex % x));
            dex = dex / x;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int dex = 59;
        int x = 16;
        System.out.println(dex + "(10) has been converted to " + cardConv(dex, x) + "(" + x + ")");
    }
}
