package com.ll.프로그래머스.레벨2.p169199;

import java.util.*;
import java.awt.*;

public class Solution {
    boolean[][] visited;
    String[][] map;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public int solution(String[] board) {
        map = new String[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];

        int[] start = new int[2];
        for(int i = 0; i < board.length; i++) {
            map[i] = board[i].split("");
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j].equals("R")) {
                    start = new int[]{i, j};
                }
            }
        }

        int answer = bfs(start[0], start[1]);


        return answer;
    }

    public int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int cnt = 1;
        boolean findGoal = false;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                Point point = queue.poll();

                for(int i = 0; i < 4; i++) {
                    int nx = point.x;
                    int ny = point.y;
                    while(!map[nx][ny].equals("D")) {
                        nx += dx[i];
                        ny += dy[i];
                        if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) break;
                    }
                    nx -= dx[i];
                    ny -= dy[i];

                    if(map[nx][ny].equals("G")) {
                        findGoal = true;
                        return cnt;
                    }

                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }

            cnt++;
        }

        if(!findGoal) return -1;

        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});

        System.out.println(answer);
    }
}