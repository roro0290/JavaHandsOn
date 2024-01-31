package com.example.leetcode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given an array of distinct integers, return all possible permutations
[A B C]
total number of permutations = 3! = 6
 */
public class Permutations {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), Arrays.stream(nums).boxed().toList(), nums.length);

        int size = result.size();
        return result;

    }

    List<List<Integer>> backtrack(List<List<Integer>> result, List<Integer> combination, List<Integer> nums, int length) {

        if (combination.size() == length  && !result.contains(combination)) {
            result.add(new ArrayList<>(combination));
        }

        for (Integer num : nums) {

//              this condition won't work for duplicates
//            if (combination.contains(num)) {
//                continue;
//            }

            combination.add(num);

            List<Integer> temp = new ArrayList<>(nums);
            temp.remove(num);

            backtrack(result, combination, temp, length); // only when this stack is complete then it will move on to the remove

            combination.remove(num);

        }

        return result;
    }


}
