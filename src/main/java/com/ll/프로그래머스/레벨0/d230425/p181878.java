package com.ll.프로그래머스.레벨0.d230425;

public class p181878 {
    public int solution(String myString, String pat) {
        int answer = 0;
        String a = myString.toLowerCase();
        String b = pat.toLowerCase();
        if(a.contains(b)) {
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }
}
