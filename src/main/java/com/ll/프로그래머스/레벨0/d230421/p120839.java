package com.ll.프로그래머스.레벨0.d230421;

public class p120839 {
    public String solution(String rsp) {
        String answer = "";
        for (int i = 0; i < rsp.length(); i++) {
            char tmp = rsp.charAt(i);
            if (tmp == '0') answer += 5;
            if (tmp == '2') answer += 0;
            if (tmp == '5') answer += 2;
        }

        return answer;
    }
}
