package com.ll.프로그래머스.레벨0;

import java.util.Arrays;

public class p120847 {
    public int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);
        return numbers[numbers.length-1] * numbers[numbers.length-2];
    }
}