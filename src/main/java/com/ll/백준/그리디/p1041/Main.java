package com.ll.백준.그리디.p1041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        long[] dice = new long[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long A = dice[0];
        long B = dice[1];
        long C = dice[2];
        long D = dice[3];
        long E = dice[4];
        long F = dice[5];

        long[] sumThree = new long[] {
                A+B+C,
                A+C+E,
                A+D+E,
                A+B+D,
                B+D+F,
                B+C+F,
                D+E+F,
                C+E+F
        };
        long[] sumTwo = new long[] {
                A+B,
                A+C,
                A+D,
                A+E,
                B+F,
                B+D,
                B+C,
                C+E,
                C+F,
                D+E,
                D+F,
                E+F
        };

        Arrays.sort(sumThree);
        Arrays.sort(sumTwo);
        Arrays.sort(dice);

        long minThree = sumThree[0];
        long minTwo = sumTwo[0];
        long minOne = dice[0];

        long resultTwo = minThree * 4 + minTwo * 4;
        long resultOver = minThree * 4 + minTwo * (4 * (N-2) * 2 + 4) + minOne * ((N-2) * (N-2) * 5 + 4 * (N-2));

        if(N == 1) {
            System.out.println(dice[0] + dice[1] + dice[2] + dice[3] + dice[4]);
        } else if(N == 2) {
            System.out.println(resultTwo);
        } else {
            System.out.println(resultOver);
        }


    }
}
