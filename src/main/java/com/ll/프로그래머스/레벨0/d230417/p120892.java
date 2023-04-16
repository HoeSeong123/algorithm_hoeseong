package com.ll.프로그래머스.레벨0.d230417;

public class p120892 {
    public String solution(String cipher, int code) {
        String answer = "";

        for (int i = code-1; i < cipher.length(); i+=code) {
            answer += cipher.charAt(i);
        }

        return answer;
    }
}
