package com.ll.프로그래머스.레벨0;

public class p120822 {
    public String solution(String my_string) {
        String answer = "";
        for(int i = my_string.length() - 1; i >= 0; i--) {
            answer += my_string.charAt(i);
        }

        return answer;
    }
}
