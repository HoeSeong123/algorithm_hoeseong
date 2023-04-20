package com.ll.프로그래머스.레벨0.d230420;

public class p181938 {
    public int solution(int a, int b) {
        int result1 = Integer.parseInt(a + "" + b);
        int result2 = 2 * a * b;

        return Math.max(result1, result2);
    }
}
