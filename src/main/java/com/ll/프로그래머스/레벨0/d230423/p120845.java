package com.ll.프로그래머스.레벨0.d230423;

public class p120845 {
    public int solution(int[] box, int n) {
        int answer = 1;
        for(int i = 0; i < 3; i++) {
            answer *= box[i] / n;
        }
        return answer;


    }
}
