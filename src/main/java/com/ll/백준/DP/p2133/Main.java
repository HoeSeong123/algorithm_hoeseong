package com.ll.백준.DP.p2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(putTile(N));
    }

    private static int putTile(int N) {
        if(N % 2 != 0) {
            return 0;
        }

        if(N == 2) {
            return 3;
        }

        if(N == 4) {
            return 11;
        }

        int sum = 0;

        for(int i = N - 4; i >= 2; i -= 2) {
            sum += putTile(i);
        }

        return putTile(N - 2) * 3 + sum * 2 + 2;
    }
}
