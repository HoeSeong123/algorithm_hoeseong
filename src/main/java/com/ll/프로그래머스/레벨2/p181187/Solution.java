package com.ll.프로그래머스.레벨2.p181187;

public class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for(long i = 1; i < r2; i++){
            long y1 = (long)Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
            long y2 = (long)Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            answer += y2 - y1;

            if(Math.pow(y1, 2) + Math.pow(i, 2) == Math.pow(r1, 2) && y1 != 0) {
                answer++;
            }
        }

        answer = 4 * answer + 4 * (r2 - r1 + 1);

        return answer;
    }
}
