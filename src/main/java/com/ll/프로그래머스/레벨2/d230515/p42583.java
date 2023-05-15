package com.ll.프로그래머스.레벨2.d230515;

import java.util.LinkedList;
import java.util.Queue;

public class p42583 {
    public static void main(String[] args) {
        int answer = solution(100, 100, new int[]{10});
        System.out.println(answer);
    }


    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int[] bridge = new int[bridge_length];
        Queue<Integer> crossingTruck = new LinkedList<>();

        int crossingWeight = 0;
        int index = 0;

        while(true) {
            answer++;

            if(!crossingTruck.isEmpty()) {
                if (crossingTruck.peek() == bridge[bridge_length - 1]) {
                    int crossedTruckWeight = crossingTruck.poll();
                    crossingWeight -= crossedTruckWeight;
                }
            }

            for(int i = bridge_length - 1; i > 0; i--) {
                bridge[i] = bridge[i - 1];
            }
            bridge[0] = 0;

            if(index < truck_weights.length && crossingWeight + truck_weights[index] <= weight) {
                crossingTruck.add(truck_weights[index]);
                crossingWeight += truck_weights[index];
                bridge[0] = truck_weights[index];
                index++;
            }

            if(index == truck_weights.length && crossingTruck.isEmpty()) {
                break;
            }


        }
        return answer;
    }


}
