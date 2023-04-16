package com.ll.프로그래머스.레벨0.d230417;

public class p120837 {
    public int solution(int hp) {
        int answer = 0;

        answer += hp / 5;
        hp %= 5;
        answer += hp / 3;
        hp %= 3;
        answer += hp;

        return answer;
    }
}
