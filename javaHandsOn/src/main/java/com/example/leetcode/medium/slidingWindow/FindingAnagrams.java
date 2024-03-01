package com.example.leetcode.medium.slidingWindow;

import java.util.ArrayList;
import java.util.List;

// Input: s = "cbaebabacd", p = "abc"
// Input: s = "abab", p = "ab"
// Leetcode 438. Find All Anagrams in a String
public class FindingAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        // convert p into a list of characters
        List<Character> pList = createCharList(p);

        // example s contains c - remove c from list & increase window
        // then remove b
        // then remove a
        // list is empty so add the index of first char to the the result
        // change the window, put back the removed char into the list and check if the next is that value
        int L = 0, R = 0, size = p.length();

        while (R < s.length()) {

            // if i am able to remove the character at R
            while (R < s.length() && pList.remove((Character) s.charAt(R))) {
                if (pList.isEmpty()) {
                    result.add(L);
                    pList.add(s.charAt(L));
                    L++;
                }
                R++;
            }

            // if not able to remove the character at R
            // check if p contains the char at R
            if (R < s.length() && p.contains(String.valueOf(s.charAt(R)))) { // if yes, then just adjust left window
                pList.add(s.charAt(L));
                L++;
            } else { // if p does not contain the char at R, we change our window to the char after that and restart
                R++;
                L = R;
                pList = createCharList(p);
            }

        }

        return result;
    }

    List<Character> createCharList(String p) {
        List<Character> pList = new ArrayList<>();
        for (char c : p.toCharArray()) {
            pList.add(c);
        }
        return pList;
    }
}
