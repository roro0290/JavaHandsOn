package com.example.leetcode.medium.frequencyCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Leetcode 1630
You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.

Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.
 */
public class ArithmeticSubarrays {

    /*
    Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
    Output: [true,false,true]
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> result = new ArrayList<>();

        int start = 0, end = 0;
        for (int i = 0; i < l.length; i++) {
            start = l[i];
            end = r[i];
            int[] array = Arrays.copyOfRange(nums, start, end + 1);
            result.add(checkArray(array));
        }

        return result;
    }

    boolean checkArray(int[] array) {

        if (array.length < 2) {
            return false;
        }

        // array sorted from smallest to largest
        Arrays.sort(array);

        int L = 0, R = 1, diff = array[R] - array[L], temp = 0;

        while (R < array.length) {
            temp = array[R] - array[L];
            if (temp == diff) {
                R++;
                L++;
            } else {
                return false;
            }
        }

        return true;
    }

}
