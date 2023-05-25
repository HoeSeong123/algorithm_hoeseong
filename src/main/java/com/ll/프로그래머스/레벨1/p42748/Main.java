package com.ll.프로그래머스.레벨1.p42748;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] tmp = sol.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

        for(int i : tmp) {
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            int indexAnswer = 0;
            for(int[] arr : commands) {
                int i = arr[0];
                int j = arr[1];
                int k = arr[2];
                int[] splitArr = new int[j - i + 1];
                int index = 0;

                for(int n = i; n <= j; n++) {
                    splitArr[index++] = array[n - 1];
                }

                Arrays.sort(splitArr);

                answer[indexAnswer++] = splitArr[k - 1];
            }
            return answer;
        }
    }
}
