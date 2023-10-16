package com.ll.프로그래머스.레벨2.p148653;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        String[] numStr = (storey + "").split("");
        int[] num = new int[numStr.length];

        for(int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(numStr[i]);
        }

        int carry = 0;

        for(int i = num.length - 1; i >= 1; i--) {
            num[i] += carry;
            carry = 0;

            if(num[i - 1] >= 5) {
                if(num[i] >= 5) {
                    answer += 10 - num[i];
                    carry = 1;
                } else {
                    answer += num[i];
                }
            } else {
                if(num[i] > 5) {
                    answer += 10 - num[i];
                    carry = 1;
                } else {
                    answer += num[i];
                }
            }

        }

        num[0] += carry;
        carry = 0;
        if(num[0] > 5) {
            answer += 10 - num[0];
            carry = 1;
        } else {
            answer += num[0];
        }

        if(carry == 1) {
            answer++;
        }

        return answer;
    }
}