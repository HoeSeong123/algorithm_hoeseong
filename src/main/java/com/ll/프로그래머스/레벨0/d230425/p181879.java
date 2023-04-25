package com.ll.프로그래머스.레벨0.d230425;

public class p181879 {
    public int solution(int[] num_list) {
        int answer;
        if(num_list.length >= 11) {
            answer = 0;
            for (int i = 0; i < num_list.length; i++) {
                answer += num_list[i];
            }
        } else {
            answer = 1;
            for (int i = 0; i < num_list.length; i++) {
                answer *= num_list[i];
            }
        }
        return answer;
    }
}
