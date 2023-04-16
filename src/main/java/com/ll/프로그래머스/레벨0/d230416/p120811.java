package com.ll.프로그래머스.레벨0.d230416;

import java.util.Arrays;

public class p120811 {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);

        answer = array[array.length/2];

        return answer;
    }
}
