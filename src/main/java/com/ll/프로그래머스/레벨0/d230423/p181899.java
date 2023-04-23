package com.ll.프로그래머스.레벨0.d230423;

public class p181899 {
    public int[] solution(int start, int end) {
        int[] answer = new int[start - end + 1];

        int index = 0;

        for(int i = start; i >= end; i--) {
            answer[index] = i;
            index++;
        }

        return answer;
    }
}
