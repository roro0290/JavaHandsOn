package com.example.leetcode.easy;

import org.junit.Test;

public class TwoSumTest {

    @Test
    public void testTwoSum() {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
    }

    @Test
    public void testThirdTryTwoSum() {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] result = twoSum.thirdTryTwoSum(nums, target);
    }
}
