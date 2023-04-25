package com.ll.프로그래머스.레벨0.d230425;

public class p181929 {
    public int solution(int[] num_list) {
        int result1 = 1;
        int result2 = 0;
        for(int i = 0; i < num_list.length; i++) {
            result1 *= num_list[i];
            result2 += num_list[i];
        }
        if(result1 < Math.pow(result2, 2)) return 1;
        else return 0;
    }
}
