package com.ll.백준.그리디.p13975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Long> files = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                files.add(Long.parseLong(st.nextToken()));
            }

            long result = 0;

            while(true) {
                long sum = 0;
                sum += files.poll();
                sum += files.poll();
                files.add(sum);
                result += sum;

                if(files.size() == 1) break;
            }

            System.out.println(result);
        }
    }
}
