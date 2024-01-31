package com.example.leetcode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        // pointer j is used to track the index where the element needs to be placed

        int unique = 0;

        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[unique] = nums[i];
                unique+=1;

            }
        }

        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        List<Integer> collect = set.stream().sorted().collect(Collectors.toList());
        for(int i = 0;i<collect.size();i++){
            nums[i] = collect.get(i);
        }

        return collect.size();

    }


}
