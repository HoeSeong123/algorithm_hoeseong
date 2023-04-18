package com.ll.프로그래머스.레벨2.d230418;

import java.util.*;

public class p87377 {
}

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        Set<Point> intersections = intersections(line);
        char[][] matrix = drawMatrix(intersections);
        answer = drawResult(matrix);
        return answer;
    }

    public Point intersection(int[] line1, int[] line2) {
        double A = line1[0];
        double B = line1[1];
        double E = line1[2];

        double C = line2[0];
        double D = line2[1];
        double F = line2[2];

        double denominator = A * D - B * C;

        if (denominator == 0) return null;

        double x = (B * F - E * D) / denominator;
        double y = (E * C - A * F) / denominator;

        //x 또는 y가 실수인 경우만 취급한다.
        if (x != (long) x) return null;
        if (y != (long) y) return null;


        return Point.of(x, y);
    }

    public Set<Point> intersections(int[][] line) {
        Set<Point> points = new HashSet<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] line1 = line[i];
                int[] line2 = line[j];

                Point point = intersection(line1, line2);

                if (point != null) points.add(point);
            }
        }

        return points;
    }

    public Point getMinPoint(Set<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : points) {
            x = Math.min(point.x, x);
            y = Math.min(point.y, y);
        }

        return Point.of(x, y);
    }


    public Point getMaxPoint(Set<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : points) {
            x = Math.max(point.x, x);
            y = Math.max(point.y, y);
        }

        return Point.of(x, y);
    }

    public char[][] drawEmptyMatrix(Set<Point> points) {
        Point maxPoint = getMaxPoint(points);
        Point minPoint = getMinPoint(points);

        int height = (int) (maxPoint.y - minPoint.y + 1);
        int width = (int) (maxPoint.x - minPoint.x + 1);

        char[][] matrix = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = '.';
            }
        }

        return matrix;
    }

    public Set<Point> makePositive(Set<Point> points) {
        Point minPoint = getMinPoint(points);

        Set<Point> positivePoints = new HashSet<>();

        for (Point point : points) {
            long x = point.x - minPoint.x;
            long y = point.y - minPoint.y;
            positivePoints.add(Point.of(x, y));
        }

        return positivePoints;
    }

    public char[][] drawMatrix(Set<Point> points) {
        char[][] emptyMatrix = drawEmptyMatrix(points);
        Set<Point> positivePoints = makePositive(points);

        for (Point point : positivePoints) {
            emptyMatrix[(int)point.y][(int)point.x] = '*';
        }

        return emptyMatrix;
    }

    public String[] drawResult(char[][] matrix) {
        String[] result = new String[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            result[matrix.length - i - 1] = "";
            for (int j = 0; j < matrix[i].length; j++) {
                result[matrix.length - i - 1] += matrix[i][j];
            }
        }

        return result;
    }
}

class Point {
    public final long x;
    public final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(long x, long y) {
        return new Point(x, y);
    }

    public static Point of(double x, double y) {
        return of((long) x, (long) y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}