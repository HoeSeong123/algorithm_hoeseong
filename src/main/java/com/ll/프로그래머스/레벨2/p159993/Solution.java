package com.ll.프로그래머스.레벨2.p159993;
import java.util.*;
import java.awt.*;

public class Solution {
    public String[][] map;
    public Point start;
    public boolean[][] visited;
    public int[] dx = new int[]{-1, 1, 0, 0};
    public int[] dy = new int[]{0, 0, -1, 1};
    public int M;
    public int N;;

    public int solution(String[] maps) {
        int answer = 0;
        M = maps.length;
        N = maps[0].length();
        map = new String[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < maps.length; i++) {
            map[i] = maps[i].split("");
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j].equals("S")) {
                    start = new Point(i, j);
                }
            }
        }

        answer = bfs();

        return answer;
    }

    public int bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        int dist = 0;
        int cnt = 1;
        boolean openLever = false;
        boolean findGoal = false;

        while(!queue.isEmpty()) {
            int num = queue.size();
            for(int i = 0; i < num; i++) {
                Point point = queue.poll();
                boolean findLever = false;

                for(int j = 0; j < 4; j++) {
                    int nx = dx[j] + point.x;
                    int ny = dy[j] + point.y;

                    if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                    if(visited[nx][ny]) continue;

                    if(map[nx][ny].equals("S") || map[nx][ny].equals("O") || map[nx][ny].equals("E") && !openLever) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                    if(map[nx][ny].equals("L")) {
                        openLever = true;
                        visited = new boolean[M][N];
                        dist += cnt;
                        cnt = 0;
                        queue.clear();
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        findLever = true;
                        break;
                    }
                    if(map[nx][ny].equals("E") && openLever) {
                        dist += cnt;
                        findGoal = true;
                        return dist;
                    }

                }

                if(findLever) break;
            }

            cnt++;
        }

        if(!findGoal || !openLever) return -1;
        return dist;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int answer = sol.solution(new String[]{"ESLOO","OXXXO","OOOOO","OXXXO","OOOOO"});

        System.out.println(answer);
    }
}