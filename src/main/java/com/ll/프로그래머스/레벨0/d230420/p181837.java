package com.ll.프로그래머스.레벨0.d230420;

public class p181837 {
    public int solution(String[] order) {
        int answer = 0;
        for (String element : order) {
            if(element.contains("americano")) {
                answer += 4500;
            }
            if (element.contains("cafelatte")) {
                answer += 5000;
            }
            if (element.contains("anything")) {
                answer += 4500;
            }
        }
        return answer;
    }
}
