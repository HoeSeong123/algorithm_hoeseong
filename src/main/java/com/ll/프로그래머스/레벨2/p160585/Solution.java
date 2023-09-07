package com.ll.프로그래머스.레벨2.p160585;

public class Solution {
    public int solution(String[] board) {
        int answer = 1;

        String[][] map = new String[3][3];
        int[] bingoY = new int[3];
        int[] bingoX = new int[3];
        int countO = 0;
        int countX = 0;

        for(int i = 0; i < 3; i++) {
            map[i] = board[i].split("");
            for(int j = 0; j < 3; j++) {
                if(map[i][j].equals("O")) {
                    countO++;
                    bingoX[j]++;
                    bingoY[i]++;
                }
                if(map[i][j].equals("X")) {
                    countX++;
                    bingoX[j]--;
                    bingoY[i]--;
                }
            }
        }

        boolean OWin = false;
        boolean XWin = false;

        for(int i = 0; i < 3; i++) {
            if(bingoX[i] == 3 || bingoY[i] == 3) {
                OWin = true;
            } else if(bingoX[i] == -3 || bingoY[i] == -3) {
                XWin = true;
            }
        }

        if(map[0][0].equals("O") && map[1][1].equals("O") && map[2][2].equals("O") ||map[2][0].equals("O") && map[1][1].equals("O") && map[0][2].equals("O")) {
            OWin = true;
        }

        if(map[0][0].equals("X") && map[1][1].equals("X") && map[2][2].equals("X") ||map[2][0].equals("X") && map[1][1].equals("X") && map[0][2].equals("X")) {
            XWin = true;
        }

        if(countO < countX) answer = 0;
        if(countO == countX && OWin) answer = 0;
        if(countO == countX + 1 && XWin) answer = 0;
        if(countO > countX + 1) answer = 0;

        return answer;
    }
}
