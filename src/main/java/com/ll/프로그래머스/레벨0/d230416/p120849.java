package com.ll.프로그래머스.레벨0.d230416;

public class p120849 {
    public String solution(String my_string) {
        String answer = "";
        answer = my_string.replaceAll("[aeiou]", "");

        return answer;
    }
}
