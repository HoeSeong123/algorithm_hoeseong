package com.ll.프로그래머스.레벨2.d230421;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class p42860Test {
    @Test
    @DisplayName("A->B")
    void t01() {
        assertThat(
                new Solution().setAlphabet('B')
        ).isEqualTo(1);
    }

    @Test
    @DisplayName("A->C")
    void t02() {
        assertThat(
                new Solution().setAlphabet('Z')
        ).isEqualTo(1);
    }

    @Test
    @DisplayName("AA->BB")
    void t03() {
        assertThat(
                new Solution().solution("BB")
        ).isEqualTo(3);
    }

    @Test
    @DisplayName("AAA->ABC")
    void t04() {
        assertThat(
                new Solution().solution("ABC")
        ).isEqualTo(5);
    }

    @Test
    @DisplayName("Z")
    void t05() {
        assertThat(
                new Solution().solution("Z")
        ).isEqualTo(1);
    }

    @Test
    @DisplayName("JEROEN")
    void t06() {
        assertThat(
                new Solution().solution("JEROEN")
        ).isEqualTo(56);
    }

    @Test
    @DisplayName("JAN")
    void t07() {
        assertThat(
                new Solution().solution("JAN")
        ).isEqualTo(23);
    }


}