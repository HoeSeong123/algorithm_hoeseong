package com.ll.프로그래머스.레벨0.d230416;

public class p120836 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) answer++;
        }

        return answer;
    }
}
