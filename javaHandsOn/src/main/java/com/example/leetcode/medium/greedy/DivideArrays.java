package com.example.leetcode.medium.greedy;

import java.util.*;

public class DivideArrays {

    public int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[][]{};
        int[] temp = new int[3];
        int count = 0;

        // put the numbers into arrays of 3
        for (int i : Arrays.stream(nums).sorted().toArray()) {
            count = count < 3 ? 0 : count;

            temp[count] = i;
            if (count > 0 && temp[count - 1] - temp[count] > k) {
                break;
            }
            count++;
        }

        return result;
    }

}
