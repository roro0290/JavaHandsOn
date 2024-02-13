package com.example.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    /*
    Given a string s, find the length of the longest substring without repeating characters.
    -> means that within the substring, I need to check if the characters are the same -> how do i do this
     */
    public int lengthOfLongestSubstring(String s) {
        int rightPointer = 0, leftPointer = 0, max = 0, stringLength = s.length();
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();

        for (rightPointer = 0; rightPointer < stringLength; rightPointer++) {
            if (!set.contains(chars[rightPointer])) { // set does not contain the element at right pointer
                set.add(chars[rightPointer]);
                max = Math.max(max, set.size());
            } else {
                while (set.contains(chars[rightPointer])) {
                    set.remove(chars[leftPointer]);
                    leftPointer++;
                }
                set.add(chars[rightPointer]);
            }
        }

        return max;
    }

}
