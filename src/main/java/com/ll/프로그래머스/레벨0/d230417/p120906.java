package com.ll.프로그래머스.레벨0.d230417;

public class p120906 {
    public int solution(int n) {
        int answer = 0;
        String num = n + "";
        for (int i = 0; i < num.length(); i++) {
            answer += (int)num.charAt(i) - 48;
        }

        return answer;
    }

}
