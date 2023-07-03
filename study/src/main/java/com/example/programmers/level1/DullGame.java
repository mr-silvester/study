package com.example.programmers.level1;

import java.util.Stack;


public class DullGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for ( int i : moves ) {
            i = i - 1;
            for ( int j = 0; j < board.length; j++ ) {
                if ( board[j][i] == 0 ) {
                    continue;
                } else {
                    if ( basket.isEmpty() ) {
                        basket.push(board[j][i]);
                    } else {
                        if ( basket.peek().equals(board[j][i]) ) {
                            basket.pop();
                            answer += 2;
                        } else {
                            basket.push(board[j][i]);
                        }
                    }
                }
                board[j][i] = 0;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        DullGame s = new DullGame();
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };

        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

        System.out.println("result : " + s.solution( board, moves ));
    }
}
