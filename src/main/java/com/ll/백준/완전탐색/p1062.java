package com.ll.백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1062 {
    static int N;
    static int K;
    static int max;
    static List<Set<Character>> words = new ArrayList<>();
    static List<Character> alphabet = new ArrayList<>();
    static List<Character> learned = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        max = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            Set<Character> spelling = new HashSet<>();
            for (int j = 0; j < word.length(); j++) {
                spelling.add(word.charAt(j));
            }
            words.add(spelling);
        }

        if (K < 5) {
            System.out.println(max);
            return;
        }

        for (Set<Character> word : words) {
            for (char spelling : word) {
                if (!alphabet.contains(spelling)) {
                    alphabet.add(spelling);
                }
            }
        }

        if(K >= alphabet.size()) {
            System.out.println(N);
            return;
        }

        alphabet.remove(Character.valueOf('a'));
        alphabet.remove(Character.valueOf('n'));
        alphabet.remove(Character.valueOf('t'));
        alphabet.remove(Character.valueOf('c'));
        alphabet.remove(Character.valueOf('i'));

        learned.add('a');
        learned.add('n');
        learned.add('t');
        learned.add('i');
        learned.add('c');

        dfs(0, 0);
        System.out.println(max);

    }

    public static void dfs(int index, int cnt) {
        if (cnt == K - 5) {
            int answer = 0;
            for(Set<Character> word : words) {
                if(learned.containsAll(word)) {
                    answer++;
                }
            }
            max = Math.max(answer, max);
            return;
        }

        for(int i = index; i < alphabet.size(); i++) {
            learned.add(alphabet.get(i));
            dfs(i + 1, cnt + 1);
            learned.remove(Character.valueOf(alphabet.get(i)));
        }
    }
}
