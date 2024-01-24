package com.example.leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // #1: Looping
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
            // included because once the result is updated, do not need to check the others
            if (result[0] != 0 || result[1] != 0) {
                break;
            }
        }
        return result;
    }

    public int[] secondTryTwoSum(int[] nums, int target) {
        int mid = target / 2, pair, first, second;
        List<Integer> numList = Arrays.stream(nums).boxed().toList();
        int[] result = new int[2];
        for (int i = Collections.min(numList); i <= mid; i++) {
            pair = target - i;
            first = numList.indexOf(i);
            second = numList.lastIndexOf(pair);
            if (first != -1 && second != -1) {
                result[0] = first;
                result[1] = second;
                break;
            }
        }
        return result;
    }

    public int[] thirdTryTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numsMap.containsKey(complement)) {
                int indexOfComplement = numsMap.get(complement);
                if (indexOfComplement != i) {
                    result[0] = i;
                    result[1] = indexOfComplement;
                    break;
                }
            }
            Arrays.asList(Arrays.stream(nums).boxed());
        }
        return result;
    }
}
