package com.ll.프로그래머스.레벨0.d230421;

public class p181936 {
    public int solution(int number, int n, int m) {
        if(number % n == 0 && number % m ==0) return 1;
        else return 0;
    }
}
