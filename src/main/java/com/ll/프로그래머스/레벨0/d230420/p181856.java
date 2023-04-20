package com.ll.프로그래머스.레벨0.d230420;

public class p181856 {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return 1;
        else if (arr1.length < arr2.length) return -1;
        else {
            int result1 = 0;
            int result2 = 0;
            for (int num : arr1) {
                result1 += num;
            }
            for (int num : arr2) {
                result2 += num;
            }

            if (result1 > result2) return 1;
            else if (result1 < result2) return -1;
            else return 0;
        }
    }
}
