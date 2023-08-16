package com.ll.백준.BFS_DFS.p2573;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static Map<Point, Integer> aroundWater;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while(true) {
            int cnt = 0;
            visited = new boolean[N][M];
            aroundWater = new HashMap<>();

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(!visited[i][j] && map[i][j] != 0) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            if(cnt == 0) {
                System.out.println(0);
                break;
            }

            if(cnt != 1) {
                System.out.println(year);
                break;
            }

            melt();

            year++;
        }

    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int cntWater = 0;

            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(map[nx][ny] == 0) {
                    cntWater++;
                    continue;
                }
                if(visited[nx][ny]) continue;

                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }

            aroundWater.put(new Point(point.x, point.y), cntWater);
        }
    }

    static void melt() {
        for(Point point : aroundWater.keySet()) {
            int x = point.x;
            int y = point.y;

            map[x][y] -= aroundWater.get(point);
            if(map[x][y] < 0) {
                map[x][y] = 0;
            }
        }
    }
}
