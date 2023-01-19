package com.example.javaHandsOn.secretCode.code.numbers;

import java.util.*;

public class NumberFinder {

    public boolean checkKeith(int n){
        // 28 is Keith
        // 2 + 8 = 10, 8 + 10 = 18, 18 + 10 = 28
        // 1. must split and get each digit
        // 2. add it to a list in the order of 2,8
        // 3. add the sum on to the list -> 2, 8, 10
        int numOfDigits = String.valueOf(n).length(); // E.G 2
        int temp = n;
        Stack<Integer> myStack = new Stack<>();
        while(temp>0){
            myStack.add(temp%10);
            temp = temp/10;
        }

        List<Integer> myList = new ArrayList<>();
        int sum = 0, index=0;
        while(!myStack.empty()){
            myList.add(myStack.pop());
        }

        boolean isKeith = false;
        while(sum <= n){
            sum = 0;
            for(int i=0;i<numOfDigits;i++){
                sum += myList.get(index);
                index +=1;
            }
            myList.add(sum);
            if(sum == n){
                isKeith = true;
                break;
            }
            // in the next loop, we need to start to calculate sum from this index
            index = myList.size()-numOfDigits;
        }

        return isKeith;

    }

    public boolean checkComposite(int n){
        boolean isComposite = false;
        for(int i=2;i<n;i++){
            if(n%i==0){
                isComposite = true;
            }
        }
        return isComposite;
    }

    public boolean checkKeithComposite(int n){
        return checkKeith(n) && checkComposite(n);
    }
}
