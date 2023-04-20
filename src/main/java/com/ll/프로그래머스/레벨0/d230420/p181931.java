package com.ll.프로그래머스.레벨0.d230420;

public class p181931 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int number = a;

        for (int i = 0; i < included.length; i++) {
            if(included[i]) {
                answer += number;
            }
            number += d;
        }
        return answer;
    }
}
