package com.example.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Leetcode 169: Majority Element
 */
public class MajorityElement {

    // use a hashmap with key & value(= num occurrences)
    // largest: num occurrences > n/2
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > n){
                return entry.getKey();
            }
        }

        return -1;
    }

}
