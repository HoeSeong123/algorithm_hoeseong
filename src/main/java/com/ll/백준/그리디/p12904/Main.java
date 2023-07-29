package com.ll.백준.그리디.p12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        while(true) {
            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
            } else if (T.charAt(T.length() - 1) == 'B') {
                String reverse = "";
                for (int i = T.length() - 2; i >= 0; i--) {
                    reverse += T.charAt(i);
                }
                T = reverse;
            }

            if(S.length() == T.length()) {
                break;
            }
        }

        if(S.equals(T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
