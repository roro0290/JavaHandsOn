package com.example.leetcode.easy;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class RomanToIntTest {

    @Test
    public void romanToIntTest(){
        RomanToInt romanToInt = new RomanToInt();
        Assertions.assertEquals(3,romanToInt.romanToInt2("III"));
        Assertions.assertEquals(4,romanToInt.romanToInt2("IV"));
        Assertions.assertEquals(9,romanToInt.romanToInt2("IX"));
        Assertions.assertEquals(40,romanToInt.romanToInt2("XL"));
        Assertions.assertEquals(42,romanToInt.romanToInt2("XLII"));
        Assertions.assertEquals(90,romanToInt.romanToInt2("XC"));
        Assertions.assertEquals(400,romanToInt.romanToInt2("CD"));
        Assertions.assertEquals(443,romanToInt.romanToInt2("CDXLIII"));
        Assertions.assertEquals(900,romanToInt.romanToInt2("CM"));
        Assertions.assertEquals(58,romanToInt.romanToInt2("LVIII"));
        Assertions.assertEquals(1994,romanToInt.romanToInt2("MCMXCIV"));
    }

}
