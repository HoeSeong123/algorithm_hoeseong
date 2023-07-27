package com.ll.백준.그리디.p1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        Collections.sort(positive);
        Collections.sort(negative);

        int sum = 0;

        for(int i = positive.size() - 1; i >= 1; i -= 2) {
            int num1 = positive.get(i);
            int num2 = positive.get(i - 1);
            if(num1 == 1 || num2 == 1) {
                sum += num1;
                sum += num2;
            } else {
                sum += num1 * num2;
            }
        }

        if(positive.size() % 2 != 0) {
            sum += positive.get(0);
        }

        for(int i = 0; i < negative.size() - 1; i += 2) {
            int num1 = negative.get(i);
            int num2 = negative.get(i + 1);

            sum += num1 * num2;
        }

        if(negative.size() % 2 != 0) {
            sum += negative.get(negative.size() - 1);
        }

        System.out.println(sum);

    }
}
