package com.ll.백준.BFS_DFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1926 {
    private static int N;
    private static int M;
    private static int cnt;
    private static int pic_cnt;
    private static int[][] map;
    private static boolean[][] visited;
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        queue = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                    bfs();
                    if (cnt > max) max = cnt;
                    pic_cnt++;
                }
            }
        }

        System.out.println(pic_cnt + "\n" + max);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny] == true) continue;
                if (map[nx][ny] == 1) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }

            cnt++;

        }
    }
}
