package com.example.leetcode.easy.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    int[] g - provides the size of the cookie that the child wants
    int[] s - provides the size of the cookies that we have
    Example 1:
    Input: g = [1,2,3], s = [1,1]
    Output: 1
    Example 2:
    Input: g = [1,2], s = [1,2,3]
    Output: 2
    NOTE:  If s[j] >= g[i], we can assign the cookie
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        // num of satisfied children
        int n = 0;

        // sort g and s from largest to smallest
//        List<Integer> gList = Arrays.stream(g).boxed().sorted((a, b) -> Integer.compare(b, a)).toList();
//        List<Integer> sList = Arrays.stream(s).boxed().sorted((a, b) -> Integer.compare(b, a)).toList();

        // Arrays.sort will do from smallest to largest
        Arrays.sort(g);
        Arrays.sort(s);

        // loop through cookies that we have and check
        // 2 pointers
        int gPoint = g.length-1, sPoint = s.length-1;


        while (gPoint >= 0 && sPoint >= 0) {
            if (s[sPoint] >= g[gPoint]) {
                n++;
                gPoint--;
                sPoint--;
            } else {
                gPoint--;
            }
        }

        return n;
    }


}
