package com.ll.프로그래머스.레벨0.d230417;

public class p120825 {
    public String solution(String my_string, int n) {
        String answer = "";

        for (int i = 0; i < my_string.length(); i++) {
            for (int j = 0;  j < n; j++) {
                answer += my_string.charAt(i);
            }
        }

        return answer;
    }
}
