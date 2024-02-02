package com.example.leetcode.easy;

public class RemoveElement {

    /*
    remove all occurrences of val in the array
    Input: nums = [3,2,2,3], val = 3
    Output: 2, nums = [2,2,_,_]
     */
    public int removeElement(int[] nums, int val) {
        int visible = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[visible] = nums[i];
                visible += 1;
            }
        }
        return visible;
    }


}
