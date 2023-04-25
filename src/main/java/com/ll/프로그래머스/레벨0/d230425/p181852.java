package com.ll.프로그래머스.레벨0.d230425;

import java.util.Arrays;

public class p181852 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length - 5];

        Arrays.sort(num_list);

        for(int i = 5; i < num_list.length; i++) {
            answer[i-5] = num_list[i];
        }
        return answer;
    }
}
