package com.ll.프로그래머스.레벨0;

public class p120585 {
    public int solution(int[] array, int height) {
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] > height) {
                answer++;
            }
        }

        return answer;
    }
}