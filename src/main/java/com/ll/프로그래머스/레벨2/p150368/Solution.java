package com.ll.프로그래머스.레벨2.p150368;

class Solution {
    static int[] discount = {10, 20, 30, 40};
    static int maxPlusService = 0;
    static int maxCost = 0;

    public int[] solution(int[][] users, int[] emoticons) {

        findResult(0, users, emoticons, new int[emoticons.length]);

        int[] answer = {maxPlusService, maxCost};
        return answer;
    }

    private void findResult(int index, int[][] users, int[] emoticons, int[] discounts) {
        if(index == emoticons.length) {
            int plusService = 0;
            int cost = 0;

            for(int[] user : users) {
                int percent = user[0];
                int price = user[1];
                int sum = 0;

                for(int i = 0; i < emoticons.length; i++) {
                    if(discounts[i] >= percent) {
                        sum += emoticons[i] / 100 * (100 - discounts[i]);
                    }
                }

                if(sum >= price) {
                    plusService++;
                } else {
                    cost += sum;
                }
            }

            if(plusService > maxPlusService) {
                maxPlusService = plusService;
                maxCost = cost;
            } else if(plusService == maxPlusService) {
                maxCost = Math.max(cost, maxCost);
            }

            return;
        }

        for(int i = 0; i < 4; i++) {
            discounts[index] = discount[i];
            findResult(index + 1, users, emoticons, discounts);
        }
    }
}