package com.ll.프로그래머스.레벨2.p155651;

import java.util.*;

public class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] rooms = new int[60 * 24 + 10];

        for(String[] time : book_time) {
            String start = time[0];
            String end = time[1];

            rooms[calTime(start)] += 1;
            rooms[calTime(end) + 10] -= 1;
        }

        for(int i = 1; i < rooms.length - 1; i++) {
            rooms[i] += rooms[i - 1];
            answer = Math.max(rooms[i], answer);
        }

        return answer;
    }

    public int calTime(String time) {
        String[] timeArr = time.split(":");
        String hour = timeArr[0];
        String minute = timeArr[1];

        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }
}