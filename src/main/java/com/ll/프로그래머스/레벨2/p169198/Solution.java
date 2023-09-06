package com.ll.프로그래머스.레벨2.p169198;

import java.util.*;

public class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        List<Integer> answerList = new ArrayList<>();
        int[][] map = new int[n][m];
        for(int[] ball : balls) {
            int endX = ball[0];
            int endY = ball[1];
            int[] dist = new int[4];

            if(!(startX == endX && startY > endY)) {
                dist[0] = (int)Math.pow(startX - endX, 2) + (int) Math.pow(startY + endY, 2);
            }
            if(!(startX == endX && startY < endY)) {
                dist[1] = (int)Math.pow(startX - endX, 2) + (int)Math.pow(startY - (2*n-endY), 2);
            }
            if(!(startY == endY && startX > endX)) {
                dist[2] = (int)Math.pow(startY - endY, 2) + (int)Math.pow(startX + endX, 2);
            }
            if(!(startY == endY && startX < endX)) {
                dist[3] = (int)Math.pow(startY - endY, 2) + (int)Math.pow(startX - (2*m-endX), 2);
            }

            Arrays.sort(dist);

            if(dist[0] == 0) {
                answerList.add(dist[1]);
            } else {
                answerList.add(dist[0]);
            }
        }

        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] answer = sol.solution(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}});

        for(int num :answer){
            System.out.println(num);
        }
    }
}