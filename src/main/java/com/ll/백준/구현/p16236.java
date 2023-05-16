package com.ll.백준.구현;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16236 {
    static Shark shark;
    static int N;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        result = 0;
        int eatingCount = 0;

        for(int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if(map[y][x] == 9) {
                    shark = new Shark(y, x);
                    map[y][x] = 0;
                }
            }
        }

        while(true) {
            int tmpResult = result;

            bfs();

            eatingCount++;
            map[shark.y][shark.x] = 0;

            if (eatingCount == shark.size) {
                shark.size++;
                eatingCount = 0;
            }

            if(tmpResult == result) break;
        }

        System.out.println(result);
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        int[] dy = new int[]{-1, 0, 0, 1};
        int[] dx = new int[]{0, -1, 1, 0};

        int distance = 0;
        int minDistance = Integer.MAX_VALUE;
        int minY = 20;
        int minX = 20;

        boolean[][] visited = new boolean[N][N];

        queue.add(new Point(shark.y, shark.x));

        visited[shark.y][shark.x] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point point = queue.poll();

                if(map[point.y][point.x] < shark.size
                        && map[point.y][point.x] != 0
                        && distance <= minDistance) {
                    minDistance = distance;

                    if(point.y < minY || point.y == minY && point.x < minX) {
                        minY = point.y;
                        minX = point.x;
                    }
                }

                for (int j = 0; j < 4; j++) {
                    int ny = point.y + dy[j];
                    int nx = point.x + dx[j];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (visited[ny][nx] == true) continue;

                    if (map[ny][nx] <= shark.size) {
                        queue.add(new Point(ny, nx));
                        visited[ny][nx] = true;
                    }


                }
            }

            if(minDistance == distance) {
                result += distance;
                shark.y = minY;
                shark.x = minX;
                map[shark.y][shark.x] = 0;
                break;
            }
            distance++;
        }
    }

    public static class Shark {
        int y;
        int x;
        int size;

        public Shark(int y, int x) {
            this.y = y;
            this.x = x;
            this.size = 2;
        }
    }

    public static class Point {
        int y;
        int x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        boolean equals(Point point) {
            return this.y == point.y && this.x == point.x;
        }
    }
}