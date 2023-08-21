package com.ll.백준.BFS_DFS.p1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int x;
    int y;
    int cnt;

    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point o) {
        return cnt - o.cnt;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        int answer = bfs();

        System.out.println(answer);
    }

    static int bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();

        queue.add(new Point(0, 0, 0));
        visited[0][0] = true;
        int cnt = 0;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            cnt = point.cnt;

            if(point.x == M - 1 && point.y == N - 1) break;

            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 0) {
                    queue.add(new Point(nx, ny, cnt));
                    visited[nx][ny] = true;
                }
                if(map[nx][ny] == 1) {
                    queue.add(new Point(nx, ny, cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return cnt;
    }


}
