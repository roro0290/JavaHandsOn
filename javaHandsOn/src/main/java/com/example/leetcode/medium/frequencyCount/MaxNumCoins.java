package com.example.leetcode.medium.frequencyCount;

/*
Leetcode: 1561
Use frequency count instead of sorting (which is a costly operation)
Taken from: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/solutions/4324240/beats-100-counting-frequency-of-piles
 */
public class MaxNumCoins {

    public int maxCoins(int[] piles) {
        // initialised with 0
        // 10001 because that is the maximum number of coins in a pile
        int[] counts = new int[10001];

        // means that if there are 8 coins in a pile, we will increment index 8 by 1
        // if there is another pile with 8 coins, then increment index 9 by 1 again (meaning 2)
        // interpret as there are 2 piles with 8(=index) coins
        for (int i : piles) {
            counts[i]++;
        }

        // total sum of my coins
        int res = 0;
        int turns = piles.length / 3;

        // index = the number of coins in a pile
        int index = counts.length - 1;
        int aliceOrMe = 0;
        while (turns > 0) {
            // ignore index piles that do not exist (e.g. 0 number of piles with index = 7)
            // value of index will not change until its count = 0
            // this ensures that in one turn, the larges available is removed & the 2nd largest is given to me
            while (counts[index] == 0) index--;
            if (aliceOrMe % 2 != 0) {
                res += index;
                turns--;
            }
            aliceOrMe++;
            counts[index]--; //reduce the count at the largest index
        }

        return res;
    }
}
