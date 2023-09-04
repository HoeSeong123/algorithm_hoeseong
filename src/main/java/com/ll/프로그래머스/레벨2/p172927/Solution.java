package com.ll.프로그래머스.레벨2.p172927;

import java.util.*;

public class Solution {
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] split = new int[minerals.length / 5 + 1][5];

        for(int i = 0; i < minerals.length; i += 5) {
            for(int j = 0; j < 5; j++) {
                if(j + i >= minerals.length) continue;

                if(minerals[j + i].equals("diamond")) {
                    split[i / 5][j] = 3;
                }
                if(minerals[j + i].equals("iron")) {
                    split[i / 5][j] = 2;
                }
                if(minerals[j + i].equals("stone")) {
                    split[i / 5][j] = 1;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int answer = solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});

        System.out.println(answer);
    }
}