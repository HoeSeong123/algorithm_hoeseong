package com.ll.백준.이분탐색과_분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p2295 {
    static int N;
    static List<Integer> U;
    static List<Integer> sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        U = new ArrayList<>();
        sum = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            U.add(Integer.parseInt(br.readLine()));
        }

        // 배열 정렬
        Collections.sort(U);

        // 배열에서 구할 수 있는 모든 합 구하기 (x + y)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum.add(U.get(i) + U.get(j));
            }
        }

        Collections.sort(sum);

        // 배열에서 구할 수 있는 모든 차 구하기 (k - z)
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int gap = U.get(i) - U.get(j);

                // 만약 gap이 배열 U에 있고 그 값이 가장 큰 값이라면
                if (findSum(gap) && U.get(i) > answer) {
                    answer = U.get(i);
                }
            }
        }

        System.out.println(answer);

    }

    private static boolean findSum(int gap) {
        int start = 0;
        int end = sum.size() - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (gap == sum.get(mid)) {
                return true;
            } else if (sum.get(mid) < gap) {
                start = mid + 1;
            } else if (gap < sum.get(mid)) {
                end = mid - 1;
            }
        }
        return false;
    }
}
