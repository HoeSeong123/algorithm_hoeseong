package com.ll.프로그래머스.레벨2.p42839;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("011"));
    }
}

class Solution {
    public List<String> numberList = new ArrayList<>();
    public boolean[] visited;


    public int solution(String numbers) {
        int answer = 0;
        String[] numberArr = numbers.split("");
        visited = new boolean[numberArr.length];

        makeNumber(numberArr, "");

        Set<Integer> numberSet = new HashSet<>();
        for(int i = 0; i < numberList.size(); i++) {
            int number = Integer.parseInt(numberList.get(i));
            numberSet.add(number);
        }

        List<Integer> numberListFinal = new ArrayList<>(numberSet);

        for(int i = 0 ; i < numberListFinal.size(); i++) {
            if(isPrime(numberListFinal.get(i))) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void makeNumber(String[] numberArr, String number) {
        for(int i = 0; i < numberArr.length; i++) {
            if(visited[i]) {
                continue;
            }
            number += numberArr[i];
            visited[i] = true;
            numberList.add(number);
            makeNumber(numberArr, number);
            number = number.substring(0, number.length() - 1);
            visited[i] = false;
        }
    }
}

