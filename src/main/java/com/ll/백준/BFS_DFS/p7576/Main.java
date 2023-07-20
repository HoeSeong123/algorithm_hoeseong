package com.ll.백준.BFS_DFS.p7576;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        int zeroTomato = 0;

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
                if (map[i][j] == 0) {
                    zeroTomato++;
                }
            }
        }

        int count = 0;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while (true) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point point = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = point.x + dx[j];
                    int ny = point.y + dy[j];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }
                    if (map[nx][ny] == 0) {
                        queue.add(new Point(nx, ny));
                        map[nx][ny] = 1;
                        zeroTomato--;
                    }
                }
            }

            if (queue.size() == 0) {
                if (zeroTomato == 0) {
                    System.out.println(count);
                    return;
                } else {
                    System.out.println(-1);
                    return;
                }
            }

            count++;
        }
    }
}
