package com.ll.프로그래머스.레벨0;

public class p120583 {
    public int solution(int[] array, int n) {
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                answer++;
            }
        }

        return answer;
    }
}
