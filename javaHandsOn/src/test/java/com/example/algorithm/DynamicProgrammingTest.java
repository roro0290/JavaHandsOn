package com.example.algorithm;

import com.example.algorithms.DynamicProgramming;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgrammingTest {

    @Test
    public void fibonacciTest() {
        DynamicProgramming dp = new DynamicProgramming();
        Assertions.assertEquals(5, dp.fibonacci(5));
//        backtracking.fibonacci(50); TOO MANY STEPS

        Map<Integer, Double> map = new HashMap<>();
        System.out.println(dp.fibonacci(50, map));

    }

    @Test
    public void gridTravellerTest() {
        DynamicProgramming dp = new DynamicProgramming();
        Map<String, Integer> map = new HashMap<>();
        Assertions.assertEquals(3, dp.gridTraveller(2, 3, map));
        Assertions.assertEquals(3, dp.gridTraveller(3, 2, map));
        Assertions.assertEquals(6, dp.gridTraveller(3, 3, map));
        System.out.println(dp.gridTraveller(18, 18, map));
    }

    @Test
    public void canSumTest() {
        DynamicProgramming dp = new DynamicProgramming();
        Assertions.assertTrue(() -> dp.canSum(7, new int[]{5, 3, 4, 7}));
        Assertions.assertFalse(() -> dp.canSum(7, new int[]{2, 4}));
        Assertions.assertTrue(() -> dp.canSum(8, new int[]{2, 3, 4}));
        Assertions.assertFalse(() -> dp.canSum(500, new int[]{7, 14}));
    }

    @Test
    public void howSumTest() {

    }

}
