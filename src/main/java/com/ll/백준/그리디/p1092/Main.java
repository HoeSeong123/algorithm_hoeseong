package com.ll.백준.그리디.p1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> cranes = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> boxes = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        if(cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        while(!boxes.isEmpty()) {
            int index = 0;
            for(int i = 0; i < N;) {
                if(index == boxes.size()) break;
                if(cranes.get(i) >= boxes.get(index)) {
                    boxes.remove(index);
                    i++;
                } else index++;
            }
            time++;
        }
        System.out.println(time);
    }
}
