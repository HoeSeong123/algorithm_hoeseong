package com.ll.프로그래머스.레벨2.p181188;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] targets) {
        int answer = 1;

        Arrays.sort(targets, (o1, o2) -> {return o1[1] - o2[1];});

        int end = targets[0][1];

        for(int[] target : targets) {
            if(target[0] >= end) {
                end = target[1];
                answer++;
            }
        }

        return answer;
    }
}
