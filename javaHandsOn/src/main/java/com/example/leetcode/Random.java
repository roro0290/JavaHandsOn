package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Random {

    public static void main(String[] args) {
        List<Integer> fruits = new ArrayList<>();
        fruits.add(1);
        fruits.add(2);
        fruits.add(2);
        fruits.add(2);
        fruits.add(2);
        fruits.add(5);

        int L = 0, R = 1;

        while(R<fruits.size()){

            if(fruits.get(L) != fruits.get(R)){
                fruits.remove(L); // because when we remove, the index decreases
                fruits.remove(R-1);
            }else{
                R++;
            }
        }

        System.out.println(fruits.size());

    }
}
