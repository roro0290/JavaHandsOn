package com.example.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class ValidParenthesesTest {

    @Test
    public void isValidTest(){
        ValidParentheses vp = new ValidParentheses();
        Assertions.assertTrue(() -> vp.isValid("()"));
        Assertions.assertTrue(() -> vp.isValid("()[]{}"));
        Assertions.assertFalse(() -> vp.isValid("("));
        Assertions.assertFalse(() -> vp.isValid("(]"));
        Assertions.assertFalse(() -> vp.isValid("){"));
        Assertions.assertFalse(() -> vp.isValid("[([]])"));
        Assertions.assertFalse(() -> vp.isValid("[({"));
        Assertions.assertTrue(() -> vp.isValid("{[]}"));
        Assertions.assertTrue(() -> vp.isValid("{[]}()"));
    }
}
