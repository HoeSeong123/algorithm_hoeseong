package com.ll.백준.그리디.p1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> booksPositive = new ArrayList<>();
        List<Integer> booksNegative = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num > 0) {
                booksPositive.add(num);
            } else {
                booksNegative.add(num);
            }
        }

        Collections.sort(booksPositive, Collections.reverseOrder());
        Collections.sort(booksNegative);

        List<Integer> booksToMove = new ArrayList<>();

        while(true) {
            if(booksPositive.size() + booksNegative.size() <= M) {
                if(!booksNegative.isEmpty()) {
                    booksToMove.add(Math.abs(booksNegative.get(0)));
                }
                if(!booksPositive.isEmpty()) {
                    booksToMove.add(booksPositive.get(0));
                }
                booksPositive.clear();
                booksNegative.clear();
                break;
            }

            if(booksNegative.isEmpty() || !booksPositive.isEmpty() && booksPositive.get(0) >= Math.abs(booksNegative.get(0))) {
                booksToMove.add(booksPositive.get(0));
                for(int i = 0; i < M; i++) {
                    if(!booksPositive.isEmpty()) {
                        booksPositive.remove(0);
                    }
                }
            } else if(booksPositive.isEmpty() || !booksNegative.isEmpty() && booksPositive.get(0) < Math.abs(booksNegative.get(0))){
                booksToMove.add(Math.abs(booksNegative.get(0)));
                for(int i = 0; i < M; i++) {
                    if(!booksNegative.isEmpty()) {
                        booksNegative.remove(0);
                    }
                }
            }

        }

        int distance = 0;

        for(int i = 0; i < booksToMove.size(); i++) {
            if(i == 0) {
                distance += booksToMove.get(i);
            } else {
                distance += 2 * booksToMove.get(i);
            }
        }

        System.out.println(distance);


    }
}
