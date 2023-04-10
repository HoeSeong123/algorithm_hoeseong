package com.ll.백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 1; i <= N; i++) {
            int tmp = i;
            while(tmp % 5 == 0) {
                cnt++;
                tmp /= 5;
            }
        }

        System.out.println(cnt);


    }
}
