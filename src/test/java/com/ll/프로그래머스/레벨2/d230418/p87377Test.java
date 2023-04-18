package com.ll.프로그래머스.레벨2.d230418;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class p87377Test {

    @Test
    @DisplayName("교점, [[1, -1, 0], [2, -1, 0]]")
    void t1() {
        assertThat(
                new Solution().intersection(new int[]{1, -1, 0}, new int[]{2, -1, 0})
        ).isEqualTo(
                Point.of(0, 0)
        );
    }

    @Test
    @DisplayName("교점, [[1, -1, 0], [4, -1, 0]]")
    void t1_2() {
        assertThat(
                new Solution().intersection(new int[]{1, -1, 0}, new int[]{4, -1, 0})
        ).isEqualTo(
                Point.of(0, 0)
        );
    }

    @Test
    @DisplayName("교점들, [[1, -1, 0], [2, -1, 0], [4, -1, 0]]")
    void t2() {
        assertThat(
                new Solution().intersections(new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1, 0}})
        ).isEqualTo(
                Set.of(Point.of(0, 0))
        );
    }

    @Test
    @DisplayName("교점들, [[0, 1, -1], [1, 0, -1], [1, 0, 1]]")
    void t2_2() {
        assertThat(
                new Solution().intersections(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}})
        ).isEqualTo(
                Set.of(Point.of(-1, 1), Point.of(1, 1))
        );
    }

    @Test
    @DisplayName("교점들, [[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]")
    void t2_3() {
        assertThat(
                new Solution().intersections(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})
        ).isEqualTo(
                Set.of(Point.of(4, 1), Point.of(4, -4), Point.of(-4, -4), Point.of(-4, 1), Point.of(0, 4))
        );
    }

    @Test
    @DisplayName("최소점, [[1, -1], [2, -1]]")
    void t3() {
        assertThat(
                new Solution().getMinPoint(Set.of(Point.of(1, -1), Point.of(2, -1)))
        ).isEqualTo(
               Point.of(1, -1)
        );
    }


    @Test
    @DisplayName("최소점, (4, 1), (4, -4), (-4, -4), (-4, 1), (0, 4)")
    void t3_2() {
        assertThat(
                new Solution().getMinPoint(Set.of(Point.of(4, 1), Point.of(4, -4), Point.of(-4, -4), Point.of(-4, 1), Point.of(0, 4)))
        ).isEqualTo(
                Point.of(-4, -4)
        );
    }

    @Test
    @DisplayName("최대점, [[1, -1], [2, -1]]")
    void t4() {
        assertThat(
                new Solution().getMaxPoint(Set.of(Point.of(1, -1), Point.of(2, -1)))
        ).isEqualTo(
                Point.of(2, -1)
        );
    }


    @Test
    @DisplayName("최대점, (4, 1), (4, -4), (-4, -4), (-4, 1), (0, 4)")
    void t4_2() {
        assertThat(
                new Solution().getMaxPoint(Set.of(Point.of(4, 1), Point.of(4, -4), Point.of(-4, -4), Point.of(-4, 1), Point.of(0, 4)))
        ).isEqualTo(
                Point.of(4, 4)
        );
    }

    @Test
    @DisplayName("빈 메트릭스, (1, -1), (-1, 1)")
    void t5() {
        assertThat(
                new Solution().drawEmptyMatrix(Set.of(Point.of(1, -1), Point.of(-1, 1)))
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.'},
                        {'.', '.', '.'},
                        {'.', '.', '.'}
        }
        );
    }

    @Test
    @DisplayName("emptyMatrix, [Point.of(4, -7), Point.of(-1, 6)]")
    void t5_2() {
        assertThat(
                new Solution().drawEmptyMatrix(Set.of(Point.of(4, -7), Point.of(-1, 6)))
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'}
                }
        );
    }

    @Test
    @DisplayName("양수로 만들기, [Point.of(4, -7), Point.of(-1, 6)]")
    void t6() {
        assertThat(
                new Solution().makePositive(Set.of(Point.of(4, -7), Point.of(-1, 6)))
        ).isEqualTo(
                Set.of(Point.of(5, 0), Point.of(0, 13))
        );
    }

    @Test
    @DisplayName("Matrix, [Point.of(4, -7), Point.of(-1, 6)]")
    void t7_2() {
        assertThat(
                new Solution().drawMatrix(Set.of(Point.of(4, -7), Point.of(-1, 6)))
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.', '.', '.', '*'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'*', '.', '.', '.', '.', '.'}
                }
        );
    }

    @Test
    @DisplayName("drawOnCoordinate, 2nd")
    void t8_2() {
        assertThat(
                new Solution().drawResult(
                        new char[][]{
                                {'.', '.', '.', '.', '.', '*'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'*', '.', '.', '.', '.', '.'}
                        }
                )
        ).isEqualTo(
                new String[]{
                        "*.....",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        ".....*"
                }
        );
    }
}