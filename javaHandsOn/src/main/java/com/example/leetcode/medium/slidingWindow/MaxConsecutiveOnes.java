package com.example.leetcode.medium.slidingWindow;

/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
The maximum number of consecutive 1s is 3.

condition =
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        // define R pointer
        int R = 0;

        // define max in a row
        int max = 0, temp = 0;
        int n = nums.length;

        while (R < n) {
            if (nums[R] == 1) {
                temp += 1;
                max = Math.max(temp, max);
            } else {
                temp = 0;
            }
            R++;
        }

        return max;

    }

    public int longestOnes(int[] nums, int k) {

        // define pointers
        int R = 0, L = 0, zeroTrack = 0;
        int count = 0, n = nums.length, max = 0;

        while (R < nums.length) {

            if (nums[R] == 1) {
                count++;
                R++;
                max = Math.max(max, count);
            } else { // number is 0
                if (zeroTrack < k) {
                    count++;
                    zeroTrack++;
                    R++;
                    max = Math.max(max, count);
                } else {
                    while (zeroTrack >= k) {
                        if (nums[L] == 0) {
                            zeroTrack -= 1;
                        }
                        count--;
                        L++;
                    }
                }
            }

        }

        return max;
    }


}
