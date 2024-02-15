package com.example.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/*
Leetcode: 12 Integer to Roman
Convert the number from Integer back to Roman
 */
public class IntegerToRoman {

    /*
    greedy style implementation where we remove the largest possible value from it
     */
    public String intToRoman(int num) {

        StringBuilder result = new StringBuilder();

        // create a map with all the integers & corresponding values
        Map<Integer,String> map = createMap();

        int remainder = 0;

        // decrement by 1 until we reach a value found in the map
        while(num>0){
            while(!map.containsKey(num)){
                num--;
                remainder++;
            }
            result.append(map.get(num));
            num = remainder;
            remainder = 0;
        }

        return result.toString();
    }

    /*
    https://leetcode.com/problems/integer-to-roman/solutions/2962674/easiest-o-1-faang-method-ever
     */
    String intToRoman2(int num) {
        String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hrns = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] ths ={"","M","MM","MMM"};

        return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }

    Map<Integer,String> createMap(){
        Map<Integer,String> map = new HashMap<>();

        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");

        return map;
    }

}
