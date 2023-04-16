package com.ll.프로그래머스.레벨0.d230417;

public class p120908 {
    public int solution(String str1, String str2) {
        int answer = 0;

        if (str1.contains(str2)) answer = 1;
        else answer = 2;

        return answer;
    }
}
