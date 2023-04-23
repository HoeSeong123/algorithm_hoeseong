package com.ll.프로그래머스.레벨2.d230421;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p42860 {
}


class Solution {
    List<Character> spelling = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    public int solution(String name) {
        int answer = 0;
        int index = 0;
        String startName = "A".repeat(name.length());

        while(true) {
            if(startName.equals(name)) break;

            int currentIndex = spelling.indexOf(name.charAt(index));

            if(currentIndex <= 13) {
                answer += currentIndex - spelling.indexOf('A');
            } else {
                answer += 26 - currentIndex;
            }
            if(index != name.length() - 1) {
                answer++;
            }
        }

        return answer;
    }

    public int setAlphabet(char name) {
        int index = spelling.indexOf(name);

        if(index <= 13) {
            return index;
        } else {
            return 26 - index;
        }
    }

    public int findBest(int index) {

    }
}

//A B C D E F G H I J K L M | N O P Q R S T U V W X Y Z
//1 2 3 4 5 6 7 8 9 0 1 2 3 | 4 5 6 7 8 9 0 1 2 3 4 5 6