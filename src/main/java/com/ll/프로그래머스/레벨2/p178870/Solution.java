package com.ll.프로그래머스.레벨2.p178870;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] sequence, int k) {

        int N = sequence.length;
        int left = 0, right = N - 1;
        int sum = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(R < N && sum < k) {
                sum += sequence[R++];
            }

            if(sum == k) {
                int range = R - L;
                if(right - left + 1> range) {
                    left = L;
                    right = R - 1;
                }
            }

            sum -= sequence[L];
        }

        int[] answer = {left, right};
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] answer = sol.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);

        for(int num : answer) {
            System.out.print(num);
        }
    }
}