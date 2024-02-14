package com.example.leetcode.medium;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MediumTest {

    @Test
    public void maxNumCoinsTest() {
        MaxNumCoins coins = new MaxNumCoins();
        Assertions.assertEquals(9, coins.maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        Assertions.assertEquals(4, coins.maxCoins(new int[]{2, 4, 5}));
        Assertions.assertEquals(18, coins.maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
    }
}
