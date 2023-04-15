package com.ll.프로그래머스.레벨0;

import java.util.Arrays;

public class p120821 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];

        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[num_list.length-1-i];
        }
        return answer;
    }
}
