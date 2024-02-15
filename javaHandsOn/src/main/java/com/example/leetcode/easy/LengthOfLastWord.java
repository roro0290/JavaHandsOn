package com.example.leetcode.easy;

/*
Leetcode: 58
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        // remove any trailing spaces
        s = s.trim();

        int length = 0, index = s.length() - 1;

        // iterate from the back and keep count until you encounter a space
        // index>=0 is for the scenario that there is only 1 character or there are no spaces at all
        while (index >= 0 && s.charAt(index) != ' ') {
            length++;
            index--;
        }

        return length;
    }

}
