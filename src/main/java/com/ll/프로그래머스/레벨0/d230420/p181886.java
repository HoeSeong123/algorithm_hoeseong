package com.ll.프로그래머스.레벨0.d230420;

public class p181886 {
    public String[] solution(String[] names) {
        String[] answer = new String[(names.length-1) / 5 + 1];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = names[i * 5];
        }

        return answer;
    }
}
