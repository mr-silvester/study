package com.example.programmers.level2;

import java.util.Arrays;

public class EmoticonEvent {
    static int[][] discounts;
    static int[] answer;
    static boolean[] visited;
    static int[] index;
    public void init(int N) {
        int dc = 40;
        discounts = new int[4][N];
        visited = new boolean[N];
        index = new int[N + 1];
        for(int i = 0; i < 4; i++, dc -= 10)
            for(int j = 0; j < N; j++)
                discounts[i][j] = dc;

        for(int i = 0; i < index.length; i++)
            index[i] = 0;
    }
    public void dfs(int[][] users, int[] emoticons,int start, int N) {
        if(start == N) {
            //계산
            int join = 0; //answer[0]
            int sell = 0; //answer[1]
            int sum = 0;
            for(int i = 0; i < users.length; i++) {
                sum = 0;
                for(int j = 0; j < N; j++) {
                    //System.out.println(emoticons[j] + "의 "+discounts[index[j]][j]+"%할인 후 가격 = " + price);
                    if(users[i][0] <= discounts[index[j]][j]) { //생각했던 할인율 보다 높으면 일단 삼
                        int price = emoticons[j] - emoticons[j] * discounts[index[j]][j] / 100;
                        sum += price;
                    }
                }
                if(sum >= users[i][1])
                    join++;
                else
                    sell += sum;
            }
            if(join > answer[0]) {
                answer[0] = join;
                answer[1] = sell;
            }
            else if(join == answer[0] && answer[1] < sell)
                answer[1] = sell;
            return ;
        }

        for(int i = 0; i < 4; index[start]++,i++) {
            index[start + 1] = 0;
            dfs(users, emoticons, start + 1, N);
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        init(emoticons.length); //초기화
        dfs(users,emoticons, 0, emoticons.length);

        return answer;
    }

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        EmoticonEvent s = new EmoticonEvent();
        System.out.println("result : " + Arrays.toString(s.solution(users, emoticons)));
    }
}
