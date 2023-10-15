package com.ll.프로그래머스.레벨2.p12973;

import java.util.*;

class Solution
{
    public int solution(String s) {

        if(s.length()%2 != 0) return 0;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++) {
            if(stack.size() > 0 && stack.peek() == s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        if(stack.isEmpty())
            return 1;
        else
            return 0;

    }
}