package com.ll.프로그래머스.레벨0.d230416;

public class p120809 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i<numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }

        return answer;
    }
}
