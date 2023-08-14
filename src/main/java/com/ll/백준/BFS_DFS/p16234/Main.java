package com.ll.백준.BFS_DFS.p16234;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static ArrayList<Point> pointList;
    static int sum;
    static int cnt;
    static boolean isChanged;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        while(true) {
            visited = new boolean[N][N];
            isChanged = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                        for(int k = 0; k < pointList.size(); k++) {
                            Point point = pointList.get(k);
                            int x = point.x;
                            int y = point.y;

                            map[x][y] = sum / cnt;
                        }
                    }
                }
            }


            if(!isChanged) break;
            result++;
        }

        System.out.println(result);
    }

    static void bfs(int x, int y) {
        sum = map[x][y];
        cnt = 1;

        Queue<Point> queue = new LinkedList<>();
        pointList = new ArrayList<>();
        queue.add(new Point(x, y));
        pointList.add(new Point(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + point.x;
                int ny = dy[i] + point.y;

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(Math.abs(map[point.x][point.y] - map[nx][ny]) <= R && Math.abs(map[point.x][point.y] - map[nx][ny]) >= L) {
                    queue.add(new Point(nx, ny));
                    pointList.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    sum += map[nx][ny];
                    cnt++;
                    isChanged = true;
                }
            }
        }
    }
}
