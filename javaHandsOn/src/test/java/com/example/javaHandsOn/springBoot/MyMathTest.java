package com.example.javaHandsOn.springBoot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {
    private MyMath myMath = new MyMath();

    @BeforeEach
    void beforeEach(){
        System.out.println("before each");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("before all");
    }

    @Test
    void calculateSum_withThreeMemberArray(){
        assertEquals(6,myMath.calculateSum(new int[]{1,2,3}));
    }

    @Test
    void calculateSum_withEmptyArray(){
        assertEquals(0,myMath.calculateSum(new int[]{}));
    }
}
