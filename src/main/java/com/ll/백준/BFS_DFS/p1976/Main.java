package com.ll.백준.BFS_DFS.p1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    map[i].add(j);
                }
            }
        }

        int[] goal = Arrays
                .stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(value -> value - 1)
                .toArray();

        boolean result = true;

        for(int i = 0; i < goal.length - 1; i++) {
            int num1 = goal[i];
            int num2 = goal[i + 1];

            visited = new boolean[N];
            boolean moveOne = dfs(num1, num2);
            if(!moveOne) {
                result = false;
            }
        }

        if(result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean dfs(int a, int b) {
        visited[a] = true;

        if(a == b) {
            return true;
        }

        for(int num : map[a]) {
            if(!visited[num]) {
                visited[num] = true;
                boolean result =  dfs(num, b);
                if(result) return result;
            }
        }

        return false;
    }
}
