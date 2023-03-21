package com.ll.정회성.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p2504 {
    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] brackets = br.readLine().split("");

        int answer = 0;
        int tmp = 1;

        for (int i = 0; i < brackets.length; i++) {
            String bracket = brackets[i];
            if(bracket.equals("(")) {
                stack.push(bracket);
                tmp *= 2;
            } else if(bracket.equals(")")) {
                if(stack.isEmpty() || !stack.peek().equals("(")) {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if(brackets[i-1].equals("(")) {
                    answer += tmp;
                }
                tmp /= 2;
            } else if(bracket.equals("[")) {
                stack.push(bracket);
                tmp *= 3;
            } else if(bracket.equals("]")) {
                if(stack.isEmpty() || !stack.peek().equals("[")) {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if(brackets[i-1].equals("[")) {
                    answer += tmp;
                }
                tmp /= 3;
            } else {
                System.out.println(0);
                return;
            }
        }

        if(!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
