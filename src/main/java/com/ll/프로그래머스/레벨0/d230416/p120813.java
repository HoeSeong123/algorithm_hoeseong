package com.ll.프로그래머스.레벨0.d230416;

public class p120813 {
    public int[] solution(int n) {
        int[] answer = new int[(n + 1) / 2];

        for (int i = 0; i < (n + 1) / 2; i++) {
            answer[i] = 2 * i + 1;
        }

        return answer;
    }
}
