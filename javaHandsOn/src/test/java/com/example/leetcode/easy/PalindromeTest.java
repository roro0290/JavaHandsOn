package com.example.leetcode.easy;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PalindromeTest {

    @Test
    public void isPalindromeTestOne(){
        Palindrome palindrome = new Palindrome();
        Assertions.assertTrue(palindrome.isPalindrome(121));
    }

    @Test
    public void isPalindromeTestTwo(){
        Palindrome palindrome = new Palindrome();
        Assertions.assertTrue(palindrome.isPalindromeTryTwo(1221));
    }

    @Test
    public void isPalindromeTestThree(){
        Palindrome palindrome = new Palindrome();
        Assertions.assertTrue(palindrome.isPalindromeTryThree(1221));
        Assertions.assertTrue(palindrome.isPalindromeTryThree(12321));
    }

    @Test
    public void isPalindromeTestFour(){
        Palindrome palindrome = new Palindrome();
        Assertions.assertTrue(palindrome.isPalindrome("."));
        Assertions.assertTrue(palindrome.isPalindrome("A man, a plan, a canal: Panama"));

    }


}
