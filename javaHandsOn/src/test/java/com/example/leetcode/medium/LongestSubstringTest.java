package com.example.leetcode.medium;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LongestSubstringTest {

    @Test
    public void testOne() {
        LongestSubstring ls = new LongestSubstring();
        Assertions.assertEquals(3, ls.lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(1, ls.lengthOfLongestSubstring("bbbbb"));
        Assertions.assertEquals(3, ls.lengthOfLongestSubstring("pwwkew"));
        Assertions.assertEquals(1, ls.lengthOfLongestSubstring(" "));
    }
}
