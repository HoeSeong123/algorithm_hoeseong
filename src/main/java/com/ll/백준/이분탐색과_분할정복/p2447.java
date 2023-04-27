package com.ll.백준.이분탐색과_분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2447 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        makeStar(N, 0, 0, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void makeStar(int N, int x, int y, boolean blank) {
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;

        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                makeStar(size, i, j, count == 5);
            }
        }
    }


}
