package com.ll.프로그래머스.레벨0.d230425;

public class p181863 {
    public String solution(String rny_string) {
        String answer = "";
        String[] tmp = rny_string.split("");
        for(int i = 0; i < tmp.length; i++) {
            if(tmp[i].equals("m")) {
                tmp[i] = "rn";
            }
            answer += tmp[i];
        }
        return answer;
    }
}
