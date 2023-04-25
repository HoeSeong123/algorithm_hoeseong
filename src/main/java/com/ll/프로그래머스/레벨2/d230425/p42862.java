package com.ll.프로그래머스.레벨2.d230425;

import java.util.Arrays;

public class p42862 {
    public static void main(String[] args) {
        new Solution().solution(5, new int[]{2, 4}, new int[]{2, 3, 5});
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] uniform = new int[n];

        Arrays.fill(uniform, 1);

        for(int i=0; i<lost.length; i++) {
            uniform[lost[i] - 1]--;
        }

        for(int i=0; i<reserve.length; i++) {
            uniform[reserve[i] - 1]++;
        }

        for(int i=0; i<n; i++) {
            if(uniform[i] == 0) {
                if(i-1>=0 && uniform[i-1] == 2) {
                    uniform[i-1]--;
                    uniform[i]++;
                } else if(i+1<n && uniform[i+1] == 2) {
                    uniform[i+1]--;
                    uniform[i]++;
                } else {
                    answer--;
                }
            }
        }

        return answer;

    }
}