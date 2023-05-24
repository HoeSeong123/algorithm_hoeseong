package com.ll.프로그래머스.레벨2.p1844;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    class Solution {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};

        public int solution(int[][] maps) {
            int answer = 0;
            int[][] visited = new int[maps.length][maps[0].length];

            visited[0][0] = 1; // 시작 위치 방문체크

            // bfs 탐색
            bfs(maps, visited);
            // 도착지 값을 넣어주기
            answer = visited[maps.length - 1][maps[0].length - 1];

            // 갈 수 없다면 -1리턴
            if (answer == 0) {
                answer = -1;
            }

            return answer;
        }

        public void bfs(int[][] maps, int[][] visited) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];

                // 4방탐색
                for (int i = 0; i < 4; i++) {
                    // 이동했을 때 위치
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // 범위 벗어나는지 체크
                    // 방문했는지 체크
                    // 갈 수 있는지 체크
                    if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length
                            && visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                        // 방문했다고 체크해주기
                        visited[nx][ny] = visited[x][y] + 1;
                        // 큐에 넣기
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
