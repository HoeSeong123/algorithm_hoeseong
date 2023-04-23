package com.ll.프로그래머스.레벨0.d230423;

public class p120910 {
    public long solution(int n, int k) {
        int answer = n;

        for (int i = 1; i <= k; i++) {
            answer *= 2;
        }

        return answer;
    }
}
