package com.ll.백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p18111 {
    static int N;
    static int M;
    static int B;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        int max = 0;
        int min = 256;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;

        for (int h = min; h <= max; h++) {
            int BTemp = B;
            int time = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] > h) {
                        time += 2 * (map[i][j] - h);
                        BTemp += map[i][j] - h;
                    } else {
                        time += h - map[i][j];
                        BTemp -= h - map[i][j];
                    }
                }
            }
            if(BTemp < 0) break;
            if(time <= minTime) {
                minTime = time;
                height = h;
            }
        }

        System.out.println(minTime + " " + height);
    }
}