package com.ll.프로그래머스.레벨0.d230417;

public class p120851 {
    public int solution(String my_string) {
        int answer = 0;
        for (int i = 0; i < my_string.length(); i++) {
            if((int)my_string.charAt(i) >= 48 && (int)my_string.charAt(i) <= 57) {
                answer += (int)my_string.charAt(i) - 48;
            }
        }

        return answer;
    }
}
