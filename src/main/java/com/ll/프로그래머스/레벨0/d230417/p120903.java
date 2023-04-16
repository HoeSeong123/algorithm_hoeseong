package com.ll.프로그래머스.레벨0.d230417;

public class p120903 {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;

        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if(s1[i].equals(s2[j])) answer++;
            }
        }

        return answer;
    }
}
