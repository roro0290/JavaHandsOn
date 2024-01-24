package com.example.leetcode.easy;

public class CommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String result = strs[0];

        // how do we match the words and extract the prefix and it needs to occur from the start
        // loop the word result
        for(String str:strs){
            while(!result.equals("")){
                if(str.startsWith(result)){
                    break;
                }else{
                    result = result.substring(0,result.length()-1);
                }
            }
            ;
        }

        return result;
    }

}
