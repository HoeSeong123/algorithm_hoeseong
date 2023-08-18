package com.ll.백준.BFS_DFS.p1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, distance, bigNode;
    static ArrayList<Node>[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nodes = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes[a].add(new Node(b, w));
            nodes[b].add(new Node(a, w));
        }

        bigNode = 1;
        distance = 0;
        visited[1] = true;
        dfs(bigNode, 0);

        visited = new boolean[n + 1];
        visited[bigNode] = true;
        distance = 0;
        dfs(bigNode, distance);

        System.out.println(distance);
    }

    static class Node {
        int num;
        int weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    static void dfs(int nodeNum, int distanceSum) {
        if(distance < distanceSum) {
            distance = Math.max(distance, distanceSum);
            bigNode = nodeNum;
        }

        for(Node node : nodes[nodeNum]) {
            if(!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, distanceSum + node.weight);
            }
        }
    }
}
