package com.example.leetcode.medium.slidingWindow;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MinSizeSubArrayTest {

    @Test
    public void test() {
        MinSizeSubArray subArray = new MinSizeSubArray();
        //Assertions.assertEquals(2, subArray.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        Assertions.assertEquals(0, subArray.minSubArrayLen(2, new int[]{1,3,5}));

    }
}
