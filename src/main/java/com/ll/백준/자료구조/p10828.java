package com.ll.백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p10828 {
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String command = br.readLine();
            checkCommand(command);
        }
    }

    public static void checkCommand(String command) {
        if (command.startsWith("push")) {
            String[] tmp = command.split(" ");
            stack.push(Integer.parseInt(tmp[1]));
        }
        if (command.equals("pop")) {
            if(stack.size() == 0) {
                System.out.println(-1);
            } else {
                int num = stack.pop();
                System.out.println(num);
            }
        }
        if (command.equals("size")) {
            System.out.println(stack.size());
        }
        if (command.equals("empty")) {
            if(stack.size() == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        if (command.equals("top")) {
            if(stack.size() == 0) {
                System.out.println(-1);
            } else {
                System.out.println(stack.peek());
            }
        }
    }
}

