package com.ll.백준.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class p1916 {
    static StringTokenizer st;
    static List<List<Node>> graph = new ArrayList<>();
    static int N;
    static int M;
    static int startNode;
    static int endNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        Dijkstra(startNode);
    }

    private static void Dijkstra(int index) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];

        // distance 값 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);

        //시작 노드 초기화
        distance[index] = 0;
        pq.offer(new Node(index, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int nodeIndex = node.index;
            int weight = node.weight;

            if (weight > distance[nodeIndex]) {
                continue;
            }

            for (Node linkedNode : graph.get(nodeIndex)) {
                if(weight + linkedNode.weight < distance[linkedNode.index]) {
                    distance[linkedNode.index] = weight + linkedNode.weight;
                    pq.offer(new Node(linkedNode.index, distance[linkedNode.index]));
                }
            }
        }

        System.out.println(distance[endNode]);
    }

    static class Node implements Comparable<Node> {
        private int index;
        private int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
