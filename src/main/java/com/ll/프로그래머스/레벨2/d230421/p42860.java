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
        List<Integer> isNotA = new ArrayList<>();

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A'){
                isNotA.add(i);
            }
        }

        int index = 0;
        while(true) {
            if(spelling.indexOf(name.charAt(index)) <= 12) {
                answer += spelling.indexOf(name.charAt(index)) - 1;
            } else {
                answer += 25 - spelling.indexOf(name.charAt(index));
            }

            int countA = 0;
            int tmpIndex = index;
            while(name.charAt(tmpIndex++) == 'A') {
                countA++;
            }


        }
    }
}

//A B C D E F G H I J K L M | O P Q R S T U V W X Y Z
//1 2 3 4 5 6 7 8 9 0 1 2 3 | 4 5 6 7 8 9 0 1 2 3 4 5