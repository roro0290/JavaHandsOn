package com.example.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
2610. Convert an Array Into a 2D Array With Conditions
You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.

Example 1:

Input: nums = [1,3,4,1,2,3,1]
Output: [[1,3,4,2],[1,3],[1]]
Explanation: We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.
 */
public class FindMatrix {

    public List<List<Integer>> findMatrix(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;

        // this is like a tracker to tell which list to check
        int numList = 0;

        for (Integer n : nums) {
            while (true) {
                // there is no list, or we are trying to access a non-existent list
                // e.g. 0 < 1 --> true --> create new list
                // 1 < 1 --> false
                // --> check next condition
                // --> if list does not contain, then put num in that list
                // --> if list already contains number, increment numList = 1
                // --> 1 < 2 (1+1) so it will create a new list, add to it and then break...
                // later on if it goes to numList = 1, it will check the 2nd list if has and then ...
                if(result.size()<numList+1){
                    list = new ArrayList<>();
                    list.add(n);
                    result.add(list);
                    break;
                }
                if (!result.get(numList).contains(n)) { // existing list does not contain
                    result.get(numList).add(n);
                    break;
                }
                numList++;
            }
            numList=0;
        }

        return result;
    }

}
