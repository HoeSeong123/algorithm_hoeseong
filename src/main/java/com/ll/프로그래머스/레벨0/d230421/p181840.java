package com.ll.프로그래머스.레벨0.d230421;

import java.util.Arrays;

public class p181840 {
    public int solution(int[] num_list, int n) {
        int tmp = Arrays.stream(num_list)
                .filter(e -> e==n)
                .findFirst()
                .orElse(-1);
        if(tmp == -1) return 0;
        else return 1;
    }
}
