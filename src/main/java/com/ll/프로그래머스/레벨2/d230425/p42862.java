package com.ll.프로그래머스.레벨2.d230425;

import java.util.Arrays;

public class p42862 {
    public static void main(String[] args) {
        new Solution().solution(5, new int[]{2, 4}, new int[]{2, 3, 5});
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] uniform = new int[n];

        Arrays.fill(uniform, 1);

        for(int i=0; i<lost.length; i++) {
            uniform[lost[i] - 1]--;
        }

        for(int i=0; i<reserve.length; i++) {
            uniform[reserve[i] - 1]++;
        }

        if(uniform[n-1] == 0) {
            if(uniform[n-2] == 2) {
                uniform[n-2]--;
                uniform[n-1]++;
            }
        }

        for(int i=1; i<uniform.length - 1; i++) {
            if(uniform[i] == 0) {
                if(uniform[i-1] == 2) {
                    uniform[i-1]--;
                    uniform[i]++;
                } else if(uniform[i+1] == 2) {
                    uniform[i+1]--;
                    uniform[i]++;
                }
            }
        }

        if(uniform[0] == 0) {
            if(uniform[1] == 2) {
                uniform[1]--;
                uniform[0]++;
            }
        }

        for(int i=0; i<n; i++) {
            if(uniform[i] >= 1) {
                answer++;
            }
        }

        return answer;

    }
}
