package com.ll.프로그래머스.레벨1.p12906;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public class Solution {
        public int[] solution(int []arr) {
            int[] answer = {};
            List<Integer> answerList = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            for(int i : arr) {
                if(stack.isEmpty()) {
                    stack.add(i);
                }
                if(stack.peek() != i) {
                    answerList.add(stack.pop());
                    stack.add(i);
                }
            }

            answerList.add(stack.pop());
            answer = new int[answerList.size()];

            for(int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
    }
}

