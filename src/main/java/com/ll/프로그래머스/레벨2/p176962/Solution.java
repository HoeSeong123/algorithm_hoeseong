package com.ll.프로그래머스.레벨2.p176962;

import java.util.*;

public class Solution {
    public static String[] solution(String[][] plans) {
        List<Project> answerList = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        for(String[] plan : plans) {
            String name = plan[0];
            String[] startStr = plan[1].split(":");
            int[] start = new int[]{Integer.parseInt(startStr[0]), Integer.parseInt(startStr[1])};
            int playtime = Integer.parseInt(plan[2]);

            Project project = new Project(name, start, playtime);
            projects.add(project);
        }

        Collections.sort(projects, new Comparator<Project>() {
            @Override
            public int compare(Project p1, Project p2) {
                if(p1.start[0] == p2.start[0]) {
                    return p1.start[1] - p2.start[1];
                }
                return p1.start[0] - p2.start[0];
            }
        });

        int cnt = 1;
        PriorityQueue<Project> result = new PriorityQueue<>();
        projects.get(0).cnt = cnt++;
        result.add(projects.get(0));

        for(int i = 1; i < projects.size(); i++) {
            Project project = result.peek();
            Project project2 = projects.get(i);

            int time = calculate(project.start, project2.start);

            while(true) {
                if (time == project.playtime) {
                    answerList.add(result.poll());
                    break;
                } else if(time > project.playtime) {
                    answerList.add(result.poll());
                    time -= project.playtime;
                    if(result.isEmpty()) break;
                    project = result.peek();
                } else {
                    project.playtime -= time;
                    break;
                }
            }

            project2.cnt = cnt++;
            result.add(project2);
        }

        while(!result.isEmpty()) {
            answerList.add(result.poll());
        }

        String[] answer = new String[answerList.size()];

        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i).name;
        }

        return answer;
    }

    public static int calculate(int[] time1, int[] time2) {
        if(time1[0] == time2[0]) {
            return time2[1] - time1[1];
        }
        if(time1[0] < time2[0]) {
            int time = (time2[0] - time1[0]) * 60;
            if(time1[1] <= time2[0]) {
                time += time2[1] - time1[1];
                return time;
            } else {
                time -= time1[1] - time2[1];
                return time;
            }
        }

        return 0;
    }

    static class Project implements Comparable<Project> {
        String name;
        int[] start;
        int playtime;
        int cnt;

        public Project (String name, int[] start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }

        @Override
        public int compareTo(Project o) {
            return o.cnt - this.cnt;
        }
    }

    public static void main(String[] args) {
        String[] answer = solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});

        for(String name : answer) {
            System.out.println(name);
        }
    }
}