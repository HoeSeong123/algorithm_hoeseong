package com.ll.프로그래머스.레벨0.d230423;

public class p181940 {
    public String solution(String my_string, int x) {
        String answer = "";

        for(int i = 0; i<x; i++) {
            answer += my_string;
        }

        return answer;
    }
}
