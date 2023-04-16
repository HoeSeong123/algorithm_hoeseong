package com.ll.프로그래머스.레벨0.d230417;

public class p120909 {
    public int solution(int n) {
        int answer = 0;
        double tmp = Math.sqrt(n);

        if(tmp%1==0) answer = 1;
        else answer = 2;

        return answer;
    }
}
