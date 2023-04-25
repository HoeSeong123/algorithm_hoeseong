package com.ll.프로그래머스.레벨0.d230425;

public class p181896 {
    public int solution(int[] num_list) {
        for(int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0) return i;
        }

        return -1;
    }
}
