package com.example.leetcode.medium.slidingWindow;

public class MinSizeSubArray {

    public int minSubArrayLen(int target, int[] nums) {

        // define pointers
        int L = 0, R = 0;

        // min & sum
        int min = Integer.MAX_VALUE, sum = 0;
        int n = nums.length;

        // perform sliding window to perform min sub array
        while(R < n){
            // add the current element at R pointer
            sum += nums[R];
            // contract window
            while(sum >= target){
                min = Math.min(min, R - L + 1);
                sum -= nums[L];
                L++;
            }
            R++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }


}
