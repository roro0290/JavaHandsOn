package com.example.leetcode.easy;

/*
Leetcode: 88 merge a sorted array

The other approach is to copy all from the 2nd array into the 1st array
use Arrays.sort
 */
public class MergeSortedArray {

    /*
    The final sorted array should be stored inside the array nums1.
    QNS: how do we move elements in an array
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // define two pointers that refers to the last index (has the largest number)
        int p1 = m - 1, p2 = n - 1, current = m + n - 1;

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[current] = nums1[p1];
                current--;
                p1--;
            } else {
                nums1[current] = nums2[p2];
                current--;
                p2--;
            }
        }

    }

}
