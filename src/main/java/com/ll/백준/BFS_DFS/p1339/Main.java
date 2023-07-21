package com.ll.백준.BFS_DFS.p1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        int[] alphabetCount = new int[26];

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word);
            int size = word.length();
            for(int j = 0; j < size; j++) {
                alphabetCount[word.charAt(j) - 'A'] += Math.pow(10, size - j - 1);
            }
        }

        Arrays.sort(alphabetCount);
        int index = 9;
        int sum = 0;

        for(int i = 25; i >= 0; i--) {
            if(index == 0) {
                break;
            }
            sum += alphabetCount[i] * index;
            index--;
        }

        System.out.println(sum);
    }
}
