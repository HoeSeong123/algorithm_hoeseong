package com.ll.프로그래머스.레벨0.d230425;

public class p181842 {
    public int solution(String str1, String str2) {
        int answer = 0;
        if(str2.contains(str1)) answer = 1;
        else answer = 0;
        return answer;
    }
}
