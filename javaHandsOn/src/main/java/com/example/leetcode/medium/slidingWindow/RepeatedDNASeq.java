package com.example.leetcode.medium.slidingWindow;

import java.util.*;

/*
Leetcode: 187 Repeated DNA Sequence
 */
public class RepeatedDNASeq {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> result = new ArrayList<>();

        // if the string is exactly 10 or lesser, then there will be NO
        // 10-letter-long sequences (substrings) that occur more than once in a DNA molecule
        if (s.length() <= 10) {
            return result;
        }

        // key = 10 letter string & value = num of occurrence
        // when we get a 10 letter string, if key not present, put in with 0
        // else increase value by 1
        // filter all the keys that has 1 or more occurence into the list
        Map<String, Integer> map = new HashMap<>();

        int L = 0, R = 9;

        while (R < s.length()) {
            int temp = 0;
            String key = "";
            key = s.substring(L, R + 1);
            if (map.containsKey(key)) {
                temp = map.get(key);
                map.put(key, temp + 1);
            } else {
                map.put(key, 0);
            }
            L++;
            R++;
        }

        map.forEach((k, v) -> {
            if (v > 0) result.add(k);
        });

        return result;
    }

    /*
    Instead of using a map and updating the count variable
    we can use a SET (duplicates)
    --> meaning we want those that are a duplicate
    --> if we cannot add the value into the seen set, it is a duplicate, so add it to the repeated set
    we should consider SET instead of MAP because the number of occurences does not matter
     */
    public List<String> try2(String s) {

        if (s.length() <= 10) {
            return new ArrayList<>();
        }

        int L = 0, R = 9;
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();

        while (R < s.length()) {
            String sub = s.substring(L, R + 1);

            if (!seen.add(sub)) { // if we cannot add into the seen, means it is a repeat
                repeated.add(sub);
            }

            L++;
            R++;
        }

        return new ArrayList<>(repeated);
    }

}
