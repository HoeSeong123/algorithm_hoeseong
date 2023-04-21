package com.ll.프로그래머스.레벨0.d230421;

public class p181920 {
    public int[] solution(int start, int end) {
        int[] answer = new int[end - start + 1];
        int index = 0;

        for (int i = start; i <= end; i++) {
            answer[index] = i;
            index++;
        }

        return answer;
    }
}
