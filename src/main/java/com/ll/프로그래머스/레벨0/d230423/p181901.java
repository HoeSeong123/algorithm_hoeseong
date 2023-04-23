package com.ll.프로그래머스.레벨0.d230423;

public class p181901 {
    public int[] solution(int n, int k) {
        int[] answer = new int[n / k];

        for (int i = 0; i < n/k; i++) {
            answer[i] = (i + 1) * k;
        }

        return answer;
    }
}
