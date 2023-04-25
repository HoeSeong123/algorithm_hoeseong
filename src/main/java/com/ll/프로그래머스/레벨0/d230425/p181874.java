package com.ll.프로그래머스.레벨0.d230425;

public class p181874 {
    public String solution(String myString) {
        String answer = "";
        for(int i = 0; i < myString.length(); i++) {
            if(myString.charAt(i) == 'a' || myString.charAt(i) == 'A') {
                answer += 'A';
            }
            else {
                answer += Character.toLowerCase(myString.charAt(i));
            }
        }
        return answer;
    }
}
