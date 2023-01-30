package com.example.javaHandsOn.springBoot;

public class MyMath {
    public int calculateSum(int[] numbers){
        int sum = 0;
        for(int i:numbers){
            sum+=i;
        }
        return sum;
    }
}
