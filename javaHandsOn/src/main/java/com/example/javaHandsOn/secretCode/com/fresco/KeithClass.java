package com.example.javaHandsOn.secretCode.com.fresco;

import com.example.javaHandsOn.secretCode.code.numbers.NumberFinder;
import com.example.javaHandsOn.secretCode.code.string.ExtractString;

import java.util.List;

public class KeithClass {
    public String getInput(String conversation) {
        //Write your code

        StringBuilder output = new StringBuilder();

        ExtractString extractString = new ExtractString();
        NumberFinder numberFinder = new NumberFinder();

        List<Integer> checkKeithCompositeList = extractString.getIntFromString(conversation);
        checkKeithCompositeList.stream()
                .filter(numberFinder::checkKeithComposite)
                .forEach(output::append);

        int sumOfStringIntegers = extractString.getSumOfStringIntegers(conversation);
        output.append(sumOfStringIntegers);

        return output.toString();
    }
}