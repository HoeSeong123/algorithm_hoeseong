package com.ll.프로그래머스.레벨2.p152996;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);

        int cnt = 0;
        for(int i = 0; i < weights.length - 1; i++) {
            if(i != 0) {
                if(weights[i] == weights[i - 1]) {
                    cnt--;
                    answer += cnt;
                    continue;
                }
            }

            cnt = 0;

            for(int j = i + 1; j < weights.length; j++) {
                int num1 = weights[i];
                int num2 = weights[j];

                if(num1 == num2 ||
                        num1 * 2 == num2 * 3 ||
                        num1 * 2 == num2 * 4 ||
                        num1 * 3 == num2 * 2 ||
                        num1 * 3 == num2 * 4 ||
                        num1 * 4 == num2 * 2 ||
                        num1 * 4 == num2 * 3) {
                    cnt++;
                }
            }

            answer += cnt;
        }

        return answer;
    }
}