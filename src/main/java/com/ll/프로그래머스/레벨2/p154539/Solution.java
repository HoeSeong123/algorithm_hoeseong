package com.ll.프로그래머스.레벨2.p154539;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for(int i = 1; i < numbers.length; i++) {
            while(!stack.isEmpty()) {
                int num = stack.peek();
                if(numbers[i] > numbers[num]) {
                    answer[stack.pop()] = numbers[i];
                } else {
                    break;
                }
            }

            stack.add(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}
