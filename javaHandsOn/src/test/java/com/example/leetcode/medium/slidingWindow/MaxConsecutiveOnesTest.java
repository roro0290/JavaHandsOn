package com.example.leetcode.medium.slidingWindow;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MaxConsecutiveOnesTest {

    @Test
    public void test() {
        MaxConsecutiveOnes ones = new MaxConsecutiveOnes();
        Assertions.assertEquals(6, ones.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        Assertions.assertEquals(10, ones.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));

    }
}
