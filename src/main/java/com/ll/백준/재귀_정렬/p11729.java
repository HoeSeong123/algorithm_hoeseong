package com.ll.백준.재귀_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11729 {
    private static int cnt = 0;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int mid, int end) {
        cnt++;

        if(n==1) {
            sb.append(start + " " + end + "\n");
            return;
        }

        hanoi(n-1, start, end, mid);
        sb.append(start + " " + end + "\n");
        hanoi(n-1, mid, start, end);

    }
}
