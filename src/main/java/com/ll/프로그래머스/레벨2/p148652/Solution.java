package com.ll.프로그래머스.레벨2.p148652;

class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;

        Point point = getResult(n, l, r);
        answer += point.countOfOne;

        return answer;
    }

    private Point getResult(int n, long l, long r) {
        if(n == 1) {
            int[] num = {1, 1, 0, 1, 1};
            int cnt = 0;

            for(int i = (int)l - 1; i < r; i++) {
                if(num[i] == 1) cnt++;
            }

            return new Point(num[(int)l - 1], num[(int)r - 1], cnt);
        }

        Point point = getResult(n - 1, (l - 1) / 5 + 1, (r - 1) / 5 + 1);

        int newNumOfL = 0;
        int newNumOfR = 0;
        int newCountOfOne = point.countOfOne * 4;

        if(point.numOfL == 1) {
            if(l % 5 != 3) {
                newNumOfL = 1;
            }
            if(l % 5 == 1) newCountOfOne -= 0;
            if(l % 5 == 2) newCountOfOne -= 1;
            if(l % 5 == 3) newCountOfOne -= 2;
            if(l % 5 == 4) newCountOfOne -= 2;
            if(l % 5 == 0) newCountOfOne -= 3;
        }

        if(point.numOfR == 1) {
            if(r % 5 != 3) {
                newNumOfR = 1;
            }
            if(r % 5 == 1) newCountOfOne -= 3;
            if(r % 5 == 2) newCountOfOne -= 2;
            if(r % 5 == 3) newCountOfOne -= 2;
            if(r % 5 == 4) newCountOfOne -= 1;
            if(r % 5 == 0) newCountOfOne -= 0;
        }

        return new Point(newNumOfL, newNumOfR, newCountOfOne);
    }

    class Point {
        private int numOfL;
        private int numOfR;
        private int countOfOne;

        public Point(int numOfL, int numOfR, int countOfOne) {
            this.numOfL = numOfL;
            this.numOfR = numOfR;
            this.countOfOne = countOfOne;
        }
    }
}
