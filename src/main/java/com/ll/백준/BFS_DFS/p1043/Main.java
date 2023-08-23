package com.ll.백준.BFS_DFS.p1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Set<Integer> truePeople;
    static ArrayList<Integer>[] partyPeople;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        truePeople = new HashSet<>();
        partyPeople = new ArrayList[M];

        st = new StringTokenizer(br.readLine());
        int numTrue = Integer.parseInt(st.nextToken());
        for(int i = 0; i < numTrue; i++) {
            truePeople.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < M; i++) {
            partyPeople[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                partyPeople[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        if(truePeople.size() == 0) {
            System.out.println(M);
            return;
        }

        for(ArrayList<Integer> list : partyPeople) {
            for(Integer num : truePeople) {
                if(list.contains(num)) {
                    for(Integer person : list) {
                        truePeople.add(person);
                    }
                    break;
                }
            }
        }

        int result = 0;

        for(ArrayList<Integer> list : partyPeople) {
            boolean talkTruth = false;
            for(Integer num : truePeople) {
                if(list.contains(num)) {
                    talkTruth = true;
                    break;
                }
            }
            if(!talkTruth) {
                result++;
            }
        }

        System.out.println(result);

    }
}
