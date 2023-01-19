package com.example.javaHandsOn.secretCode.code.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
This class is used to perform string related operations:
1) Add digits that are in text form (e.g. three)
2) Extract digits that are in numeric form
 */
public class ExtractString {

    public List<Integer> getIntFromString(String input){
        List<Integer> numbers = new ArrayList<>();
        String strippedInput = input.replaceAll("\\p{IsPunctuation}","");
        for(String s:strippedInput.split(" ")){
            try{
                numbers.add(Integer.parseInt(s));
            }catch(NumberFormatException ignored){

            }
        }
        return numbers;
    }

    public int getSumOfStringIntegers(String input){
        List<Integer> myList = new ArrayList<>();
        String strippedInput = input.replaceAll("\\p{IsPunctuation}","");
        Map<String,Integer> map = createMap();
        for(String s:strippedInput.split(" ")){
            if(map.containsKey(s)) {
                myList.add(map.get(s));
            }
        }
        return myList.stream().reduce(Integer::sum).get();
    }

    public Map<String,Integer> createMap(){
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        return map;
    }
}
