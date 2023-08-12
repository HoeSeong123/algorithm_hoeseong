package com.ll.백준.BFS_DFS.p1987;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] alphabet;
    static Stack<Point> stack = new Stack<>();

    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, -1, 0, 1};
    static int max = 0;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        alphabet = new boolean[26];

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        stack.push(new Point(0, 0));
        visited[0][0] = true;
        alphabet[map[0][0] - 'A'] = true;

        dfs();

        System.out.println(max);
    }

    static void dfs() {
        Point point = stack.peek();

        max = Math.max(max, cnt);

        for(int i = 0; i < 4; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if(visited[nx][ny]) continue;
            if(alphabet[map[nx][ny] - 'A']) continue;

            stack.push(new Point(nx, ny));
            visited[nx][ny] = true;
            alphabet[map[nx][ny] - 'A'] = true;
            cnt++;
            dfs();
            cnt--;
            stack.pop();
            visited[nx][ny] = false;
            alphabet[map[nx][ny] - 'A'] = false;
        }
    }
}
