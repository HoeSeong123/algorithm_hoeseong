package com.ll.백준.BFS_DFS.p2636;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] isAir;
    static Set<Point> outside;
    static int size;

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

        int cnt = 0;
        size = 0;

        while(true) {
            visited = new boolean[N][M];
            isAir = new boolean[N][M];
            boolean changed = false;
            int result = size;
            size = 0;

            findAir();


            visited = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    outside = new HashSet<>();
                    if(map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        changed = true;
                    }

                    for(Point point : outside) {
                        map[point.x][point.y] = 0;
                    }
                }
            }

            if(!changed) {
                System.out.println(cnt);
                System.out.println(result);
                break;
            }

            cnt++;
        }


    }

    static void bfs(int x, int y) {
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        size++;

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 1) {
                    size++;
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }

                if(isAir[nx][ny]) {
                    outside.add(new Point(point.x, point.y));
                }
            }
        }
    }

    static void findAir() {
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        isAir[0][0] = true;
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(map[nx][ny] == 0 && !visited[nx][ny]) {
                    isAir[nx][ny] = true;
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
