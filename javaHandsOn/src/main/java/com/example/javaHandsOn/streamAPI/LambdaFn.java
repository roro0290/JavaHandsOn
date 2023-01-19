package com.example.javaHandsOn.streamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaFn {
    public List<Long> functionalProgramming(List<String> listOfIntegers)
    {
        //Write your code here
        List<Long> outputList = listOfIntegers
                .stream()
                .map(Long::parseLong)
                .filter(this::checkNarcissistic)
                .collect(Collectors.toList());
        return outputList;
    }

    boolean checkNarcissistic(long value){
        long original = value;
        int index = 0;
        double sum = 0;
        List<Long> intList = new ArrayList<>();
        while(value>0){
            index++;
            intList.add(value % 10);
            value /= 10;
        }
        int finalIndex = index;
        sum = intList.stream()
                .map(i -> Math.pow(i, finalIndex))
                .reduce(Double::sum)
                .get();
        return sum==original;
    }
}
