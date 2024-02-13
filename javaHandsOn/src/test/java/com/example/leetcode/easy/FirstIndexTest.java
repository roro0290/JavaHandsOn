package com.example.leetcode.easy;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FirstIndexTest {

    @Test
    public void strStrTest(){
        FirstIndex firstIndex = new FirstIndex();
        Assertions.assertEquals(2,firstIndex.strStr("hello","ll"));
        Assertions.assertEquals(-1,firstIndex.strStr("leetcode","leeto"));
        Assertions.assertEquals(0,firstIndex.strStr("aaa","aaa"));
        Assertions.assertEquals(0,firstIndex.strStr("aaa","aaa"));
    }

}
