package com.ll.백준.그리디.p11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (e1, e2) -> (e1.start == e2.start ? e1.end - e2.end : e1.start - e2.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(lectures[0].end);

        for(int i = 1; i < lectures.length; i++) {
            if(pq.peek() <= lectures[i].start) {
                pq.poll();
                pq.add(lectures[i].end);
            } else {
                pq.add(lectures[i].end);
            }
        }

        System.out.println(pq.size());
    }

    static class Lecture {
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
