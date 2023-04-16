package com.ll.프로그래머스.레벨0.d230416;

public class p120854 {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];

        for(int i = 0;  i < strlist.length; i++) {
            answer[i] = strlist[i].length();
        }

        return answer;
    }
}
