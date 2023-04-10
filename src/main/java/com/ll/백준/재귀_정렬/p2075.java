package com.ll.백준.재귀_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int result = 0;
        List<List<Integer>> numList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<Integer> tmpList = new ArrayList<>();
            String tmpStr = br.readLine();
            for (int j = 0; j < N; j++) {
                tmpList.add(Integer.parseInt(tmpStr.split(" ")[j]));
            }
        }

        while (cnt < N) {
            int max = 0;
            int max_index = -1;
            for (int i = 0; i < N; i++) {
                List<Integer> tmp = numList.get(i);
                int tmpMax = tmp.get(tmp.size() - 1);
                if(tmpMax > max) {
                    max = tmpMax;
                    max_index = i;
                }
            }
            numList.get(max_index).remove(max);
            result = max;
            cnt++;
        }

        System.out.println(result);
    }
}