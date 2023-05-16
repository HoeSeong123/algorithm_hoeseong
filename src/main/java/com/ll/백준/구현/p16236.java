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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int result = 0;
        int eatingCount = 0;

        for(int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if(map[y][x] == 9) {
                    shark = new Shark(y, x);

                }
            }
        }

        while(true) {
            int tmpResult = result;
            int tmpY = 0;
            int tmpX = 0;
            int minDistance = Integer.MAX_VALUE;

            for (int y = 0; y < N; y++) {
                boolean moved = false;
                for (int x = 0; x < N; x++) {
                    if (map[y][x] < shark.size && map[y][x] != 0) {
                        int distance = move(y, x);

                        if (distance == -1) continue;

                        if(distance < minDistance) {
                            minDistance = distance;
                            tmpY = y;
                            tmpX = x;
                        }


                    }
                }
            }

            if(minDistance == Integer.MAX_VALUE) break;

            result += minDistance;
            shark.y = tmpY;
            shark.x = tmpX;
            eatingCount++;
            map[shark.y][shark.x] = 0;

            if (eatingCount == shark.size) {
                shark.size++;
                eatingCount = 0;
            }
        }

        System.out.println(result);
    }

    public static int move(int y, int x) {
        Queue<Point> queue = new LinkedList<>();

        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};

        int distance = 0;

        boolean[][] visited = new boolean[N][N];

        queue.add(new Point(shark.y, shark.x));

        map[shark.y][shark.x] = 0;
        visited[shark.y][shark.x] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point point = queue.poll();

                if (point.equals(new Point(y, x))) {
                    return distance;
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

            distance++;
        }

        return -1;
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
