package com.ll.프로그래머스.레벨2.p154540;

import java.awt.Point;
import java.util.*;

class Solution {
    private int[][] map;
    private boolean[][] visited;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private int m;
    private int n;
    List<Integer> foods;

    public int[] solution(String[] maps) {
        int[] answer = {};
        foods = new ArrayList<>();
        m = maps.length;
        n = maps[0].length();
        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < maps.length; i++) {
            String[] tmp = maps[i].split("");
            for(int j = 0; j < tmp.length; j++) {
                if(tmp[j].equals("X")) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.parseInt(tmp[j]);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    foods.add(bfs(i, j));

                }
            }
        }

        Collections.sort(foods);
        if(foods.isEmpty()) {
            answer = new int[]{-1};
        } else {
            answer = new int[foods.size()];
            for(int i = 0; i < foods.size(); i++) {
                answer[i] = foods.get(i);
            }
        }


        return answer;
    }

    public int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int sum = map[x][y];

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + point.x;
                int ny = dy[i] + point.y;

                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] != 0) {
                    sum += map[nx][ny];
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] answer = sol.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"});

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
