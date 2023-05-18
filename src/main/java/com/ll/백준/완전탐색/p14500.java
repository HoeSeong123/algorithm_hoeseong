package com.ll.백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        int[][][] tetromino = new int[][][]{
                {{1, 1}, {1, 1}},
                {{1, 0}, {1, 1}, {1, 0}},
                {{0, 1, 0}, {1, 1, 1}},
                {{0, 1}, {1, 1}, {0, 1}},
                {{1, 1, 1}, {0, 1, 0}},
                {{1, 0}, {1, 0}, {1, 1}},
                {{0, 0, 1}, {1, 1, 1}},
                {{1, 1}, {0, 1}, {0, 1}},
                {{1, 1, 1}, {1, 0, 0}},
                {{0, 1}, {0, 1}, {1, 1}},
                {{1, 0, 0}, {1, 1, 1}},
                {{1, 1}, {1, 0}, {1, 0}},
                {{1, 1, 1}, {0, 0, 1}},
                {{0, 1, 1}, {1, 1, 0}},
                {{1, 0}, {1, 1}, {0, 1}},
                {{1, 1,0}, {0, 1, 1}},
                {{0, 1}, {1, 1}, {1, 0}},
                {{1, 1, 1, 1}},
                {{1}, {1}, {1}, {1}}
        };

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int max = 0;

        for(int i = 0; i < tetromino.length; i++) {
            int maxTmp = 0;
            for(int j = 0; j <= N - tetromino[i].length; j++) {
                for(int k = 0; k <= M - tetromino[i][0].length; k++) {
                    int result = 0;
                    for(int l = 0; l < tetromino[i].length; l++) {
                        for(int m = 0; m < tetromino[i][0].length; m++) {
                            if(tetromino[i][l][m] == 1) {
                                result += map[j + l][k + m];
                            }
                        }
                    }
                    maxTmp = Math.max(maxTmp, result);
                }
            }
            max = Math.max(max, maxTmp);
        }

        System.out.println(max);
    }
}
