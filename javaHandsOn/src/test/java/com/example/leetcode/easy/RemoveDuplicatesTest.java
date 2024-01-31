package com.example.leetcode.easy;

import org.junit.Test;

public class RemoveDuplicatesTest {

    @Test
    public void removeDuplicatesTest(){
        int[] nums = new int[]{1,1,2}; // Input array
        int[] expectedNums = new int[]{1,2}; // The expected answer with correct length

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int k = removeDuplicates.removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
