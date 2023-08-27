package com.ll.백준.BFS_DFS.p2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return cnt - o.cnt;
        }
    }

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0] = true;
        int cnt = 0;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                cnt = point.cnt;

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 1) {
                    queue.add(new Point(nx, ny, cnt));
                    visited[nx][ny] = true;
                }

                if(map[nx][ny] == 0) {
                    queue.add(new Point(nx, ny, cnt + 1));
                    visited[nx][ny] = true;
                }

                if(nx == n - 1 && ny == n - 1) {
                    return cnt;
                }
            }
        }

        return cnt;
    }
}
