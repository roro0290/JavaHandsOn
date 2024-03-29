package com.example.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public boolean isPalindrome(int x) {
        String input = Integer.toString(x);
        char[] chars = input.toCharArray();
        StringBuilder reverse = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reverse.append(chars[i]);
        }
        return reverse.toString().equals(input);
    }

    public boolean isPalindromeTryTwo(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> digitList = new ArrayList<>();
        while (x > 0) {
            digitList.add(x % 10);
            x /= 10;
        }
        int length = digitList.size();
        for (int i = 0; i < length / 2; i++) {
            if (!digitList.get(i).equals(digitList.get(length - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeTryThree(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) return false;

        int half = 0;
        while (x > half) {
            half = half * 10 + x % 10;
            x /= 10; // integer division will round it down
        }

        return x == half || x == half / 10; // the 2nd option is needed for the odd num digit scenario
    }

    /*
    Leetcode 125: Valid palindrome
    The character class has methods to check types!
     */
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        s = s.replace(" ", "");
        char[] chars = s.toCharArray();

        // if the array is empty or the array has an odd number of characters
        if (chars.length == 0) {
            return true;
        }

        // define pointers
        int L = 0, R = chars.length - 1;

        while (R >= L) {

            if (!Character.isLetterOrDigit(chars[R])) {
                R--;
            } else if (!Character.isLetterOrDigit(chars[L])) {
                L++;
            } else {
                if(chars[R] != chars[L]){
                    return false;
                }else{
                    L++;
                    R--;
                }

            }

        }

        return true;
    }

}
