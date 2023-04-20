package com.ll.프로그래머스.레벨0.d230420;

public class p230420 {
    public String solution(String my_string, int n) {
        String answer = "";
        for (int i = my_string.length() - n; i < my_string.length(); i++) {
            answer += my_string.charAt(i);
        }

        return answer;
    }
}
