package com.example.programmers.level2;

import java.util.*;

public class PathDistance {
    /**
     * 게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.
     * U: 위쪽으로 한 칸 가기
     * D: 아래쪽으로 한 칸 가기
     * R: 오른쪽으로 한 칸 가기
     * L: 왼쪽으로 한 칸 가기
     * 캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
     * 이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다. 예를 들어 위의 예시에서 게임 캐릭터가 움직인 길이는 9이지만, 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다. (8, 9번 명령어에서 움직인 길은 2, 3번 명령어에서 이미 거쳐 간 길입니다)
     * 단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.
     */
    public static int solution(String dirs) {

        /*
        //현재 포인터 (0-a, 10-k)
        char x = 'f';
        char y = 'f';
        int answer = 0;
        String ptr = String.valueOf(x) + y;
        Map<String, String> path = new HashMap<>();
        String value;
        for ( int i = 0; i < dirs.length(); i++ ) {
            switch (dirs.charAt(i)) {
                case 'U':
                    if ( x < 'k' ) {
                        value = path.get(ptr)+"";
                        if ( !value.contains("U") ) {
                            value += "U";
                            path.put(ptr, value);
                            answer ++;
                        }
                        y++;
                    }
                    break;
                case 'D':
                    if ( y > 'a' ) {
                        value = path.get(ptr)+"";
                        if ( !value.contains("D") ) {
                            value += "D";
                            path.put(ptr, value);
                            answer ++;
                        }
                        y--;
                    }
                    break;
                case 'R':
                    if ( x < 'k' ) {
                        value = path.get(ptr)+"";
                        if ( !value.contains("R") ) {
                            value += "R";
                            path.put(ptr, value);
                            answer ++;
                        }
                        x--;
                    }
                    break;
                case 'L':
                    if ( x > 'a' ) {
                        value = path.get(ptr)+"";
                        if ( !value.contains("L") ) {
                            value += "L";
                            path.put(ptr, value);
                            answer ++;
                        }
                        x--;
                    }
                    break;
            }
        }
        return answer;

         */



        int x = 5;
        int y = 5;
        int answer = 0;
        String[][] path = {
                {"", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", ""}
        };

        for ( int i = 0; i < dirs.length(); i++ ) {
            switch (dirs.charAt(i)) {
                case 'U':
                    if ( y < 10 ) {
                        if (!path[y][x].contains("U") && !path[y+1][x].contains("D")) {
                            path[y][x] += "U";
                            answer++;
                        }
                        y++;
                    }
                    break;
                case 'D':
                    if ( y > 0 ) {
                        if (!path[y][x].contains("D") && !path[y-1][x].contains("U")) {
                            path[y][x] += "D";
                            answer++;
                        }
                        y--;
                    }
                    break;
                case 'R':
                    if ( x < 10 ) {
                        if (!path[y][x].contains("R") && !path[y][x+1].contains("L")) {
                            path[y][x] += "R";
                            answer++;
                        }
                        x++;
                    }
                    break;
                case 'L':
                    if ( x > 0 ) {
                        if (!path[y][x].contains("L") && !path[y][x-1].contains("R")) {
                            path[y][x] += "L";
                            answer++;
                        }
                        x--;
                    }
                    break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String dirs = "RRUDURUDLUDLRULDUDULD";
        System.out.println("result : " + solution(dirs));
    }
}
