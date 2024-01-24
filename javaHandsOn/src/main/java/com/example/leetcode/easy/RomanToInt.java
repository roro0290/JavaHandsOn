package com.example.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {

        // these are the exception cases that must be checked first
        Map<String, Integer> mapException = new HashMap<>();
        mapException.put("IV", 4);
        mapException.put("IX", 9);
        mapException.put("XL", 40);
        mapException.put("XC", 90);
        mapException.put("CD", 400);
        mapException.put("CM", 900);

        // these are the standard cases
        Map<Character, Integer> mapStandard = new HashMap<>();
        mapStandard.put('I', 1);
        mapStandard.put('V', 5);
        mapStandard.put('X', 10);
        mapStandard.put('L', 50);
        mapStandard.put('C', 100);
        mapStandard.put('D', 500);
        mapStandard.put('M', 1000);
//        mapStandard.put("I", 1);
//        mapStandard.put("V", 5);
//        mapStandard.put("X", 10);
//        mapStandard.put("L", 50);
//        mapStandard.put("C", 100);
//        mapStandard.put("D", 500);
//        mapStandard.put("M", 1000);

        int result = 0;

        // will loop only 6 times
        for (Map.Entry<String, Integer> entry : mapException.entrySet()) {
            if (s.equals("")) break;
            if(s.contains(entry.getKey())){
                result += entry.getValue();
                s = s.replaceFirst(entry.getKey(),"");
            }
        }


        for(Character c:s.toCharArray()){
            result += mapStandard.get(c);
        }

//        for (Map.Entry<String, Integer> entry : mapStandard.entrySet()) {
//            if (s.equals("")) break;
//            while (s.contains(entry.getKey())) {
//
//                result += entry.getValue();
//                s = s.replaceFirst(entry.getKey(), "");
//            }
//        }

        return result;
    }

    // go from the back. so if the num is less than the
    public int romanToInt2(String s) {
        int ans = 0, num = 0, prev = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I' -> num = 1;
                case 'V' -> num = 5;
                case 'X' -> num = 10;
                case 'L' -> num = 50;
                case 'C' -> num = 100;
                case 'D' -> num = 500;
                case 'M' -> num = 1000;
            }
            if (num < prev) ans -= num;
            else ans += num;
            prev = num;
        }
        return ans;
    }

}
