package com.ll.프로그래머스.레벨0.d230416;

public class p120824 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];

        for (int num : num_list) {
            if (num % 2 == 0) answer[0]++;
            else answer[1]++;
        }

        return answer;
    }
}
