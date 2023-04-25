package com.ll.프로그래머스.레벨0.d230425;

public class p181884 {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for(int i = 0; i < numbers.length; i++) {
            answer+=numbers[i];
            if(answer > n) return answer;
        }
        return 0;
    }
}
