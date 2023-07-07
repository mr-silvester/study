package com.example.programmers.level2;

import java.util.*;
public class Tired {
    private final Set<Integer> used = new HashSet<>();
    private final Stack<Integer> stack = new Stack<>();
    int[][] dungeons;
    int k;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.k = k;

        int answer = 0;

        for ( int i = 0; i < dungeons.length; i++ ) {
            answer = Math.max(answer, dfs(i));
            System.out.println("인덱스 " + i + " 완료");
            used.remove(i);
        }
        return answer;
    }

    public int dfs(int num) {
        int max = stack.size();
        if ( used.size() == dungeons.length ) {
            System.out.println("모든 던전을 다 돌았습니다.");
            return dungeons.length;
        }
        if ( k < dungeons[num][0] ) {
            System.out.println("피로도 이슈로 더 돌 수 없음 : " + dungeons[num][0] + dungeons[num][1]);
            return max;
        }
        if ( !used.add(num) ) {
            System.out.println("이미 돌았던 던전 : " + dungeons[num][0] + dungeons[num][1]);
            return max;
        }
        stack.push(num);
        k -= dungeons[num][1];
        System.out.println("스택 : " + stack);
        System.out.println("셋 : " + used);
        System.out.println("현재 던전 : " + dungeons[num][0] + dungeons[num][1]);
        System.out.println("피로도 : " + k);
        max = stack.size();
        for ( int j = 0; j < dungeons.length; j++ ) {
            max = Math.max(max, dfs(j));
        }
        used.remove(num);
        stack.pop();
        k += dungeons[num][1];
        return max;
    }

    public static void main(String[] args) {
        Tired t = new Tired();
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println("result : " + t.solution(k, dungeons));
    }
}
