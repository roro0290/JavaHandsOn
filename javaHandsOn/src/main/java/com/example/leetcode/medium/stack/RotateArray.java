package com.example.leetcode.medium.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Leetcode: 189. Rotate Array
combination of stack and two pointer
when it is going in a circular way / the case repeats,
you can use moduli to reduce number of iterations
 */
public class RotateArray {

    /*
    All test cases passed but
    Time limit exceeded
     */
    public void rotate(int[] nums, int k) {

        int lastIndex = nums.length - 1;
        int temp = 0;

        k %= nums.length;
        // assign the last to the variable,
        // move everything else forward
        // then assign the variable to the first
        for (int i = k; i > 0; i--) {
            temp = nums[lastIndex];
            for (int j = lastIndex; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }

    }

    public void rotate2(int[] nums, int k) {

        // define pointers
        int length = nums.length;
        int start = 0, end = length - 1;

        k = k % length;

        // determine the final start and end positions
        while (k > 0) {
            start++;
            end++;
            k--;
            if (start == length) {
                start = 0;
            }
            if (end == length) {
                end = 0;
            }
        }

        // int at start position = nums[0]
        // int at end position = nums[length-1]

        // if end index = 0, means I need to put only the last element into the stack
        // if end index = 1, means I need to put the last two elements into the stack
        Stack<Integer> stack = new Stack<>();
        if (end != length - 1) {

            int last = length - 1;
            for (int i = 0; i <= end; i++) {
                stack.add(nums[last]);
                last--;
            }

            last = length - 1;
            while (last >= start) {
                nums[last] = nums[last - start];
                last--;
            }

            int index = 0;
            while (!stack.isEmpty()) {
                nums[index] = stack.pop();
                index++;
            }

        }

    }


    // we can solve the issue of going multiple rounds by taking the remainder
    public void rotate3(int[] nums, int k) {

        int length = nums.length;

        k %= length;

        if (k != 0) {

            int start = length - k;

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < start; i++) {
                stack.push(nums[i]);
            }

            // move the back part to the front
            int j = 0;
            for (int i = start; i < length; i++) {
                nums[j] = nums[i];
                j++;
            }

            int i = length - 1;
            while (!stack.isEmpty()) {
                nums[i] = stack.pop();
                i--;
            }


        }

    }

}
