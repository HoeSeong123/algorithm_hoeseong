package com.ll.프로그래머스.레벨0.d230425;

public class p181875 {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        for(int i = 0; i < strArr.length; i++) {
            if(i%2!=0) {
                answer[i] = strArr[i].toUpperCase();
            } else {
                answer[i] = strArr[i].toLowerCase();
            }
        }
        return answer;
    }
}
