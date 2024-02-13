package com.example.leetcode.easy;

public class FirstIndex {

    public int strStr(String haystack, String needle) {

        int x = needle.length();

        for (int i = 0; i <= haystack.length() - x + 1; i++) {
            if (needle.equals(haystack.substring(i, i + x))) {
                return i;
            }
        }

        return -1;
    }

}
