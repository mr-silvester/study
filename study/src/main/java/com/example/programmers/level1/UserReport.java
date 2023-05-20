package com.example.programmers.level1;
import java.util.*;
import java.util.stream.Collectors;

public class UserReport {
    public static int[] solution(String[] id_list, String[] report, int k) {
        //report 에서 각 유저별로 신고당한 회원을 기록 Set<Integer>[]에 저장
        //Set 의 사이즈가 k 이상이 되면 Set 의 원소에 해당하는 id_list 에 1을 더함
        int[] answer = new int[id_list.length];
        List<String> users = Arrays.stream(id_list).collect(Collectors.toList());

        Map<String, Set<String>> map = new HashMap<>();
        for ( String s : id_list ) {
            map.put(s, new HashSet<>());
        }

        //신고횟수 처리
        for (String s : report) {
            int indexOfBlank = s.indexOf(" ");
            String reporter = s.substring(0, indexOfBlank);
            System.out.println("신고자 : " + reporter);
            String reported = s.substring(indexOfBlank + 1);
            System.out.println("피신고자 : " + reported);

            map.get(reported).add(reporter);
        }
        System.out.println(map);

        for ( int i = 0; i < users.size(); i++ ) {
            Set<String> set = map.get(users.get(i));
            if ( set.size() >= k ) {
                System.out.println(users.get(i) + "는 정지입니다.");
                for ( String s : set ) {
                    System.out.println(s);
                    answer[users.indexOf(s)] += 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println("result : " + Arrays.toString(solution(id_list, report, k)));
    }
}
