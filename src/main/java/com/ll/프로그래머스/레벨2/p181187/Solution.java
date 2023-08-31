package com.ll.프로그래머스.레벨2.p181187;

public class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for(int i = 1; i < r2; i++) {
            for(int j = 1; j < i; j++) {
                double num = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));

                if(num >= r1 && num <= r2) answer++;
            }
        }


        double tmp1 = (double)Math.pow(r1, 2) / 2;
        double tmp2 = (double)Math.pow(r2, 2) / 2;

        answer = answer * 8 + 4 * (r2 - r1 + 1) + 4 * ((long)Math.sqrt(tmp2) - (long)Math.sqrt(tmp1));

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long num = solution.solution(1,5);
        System.out.println(num);
    }
}
