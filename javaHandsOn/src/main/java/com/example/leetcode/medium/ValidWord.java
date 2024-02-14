package com.example.leetcode.medium;

import java.util.Stack;

/*
Leetcode: 1003 Check if word is valid after substitutions
 */
public class ValidWord {

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int index = 0;

        while (index < s.length()) {
            stack.add(chars[index]);
            if (stack.peek() == 'c') {
                if (stack.search('a') == 3) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                } else {
                    return false;
                }
            }
            index++;
        }

        return stack.isEmpty();
    }

}
