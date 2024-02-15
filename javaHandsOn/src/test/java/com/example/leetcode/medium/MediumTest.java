package com.example.leetcode.medium;

import com.example.leetcode.medium.frequencyCount.ArithmeticSubarrays;
import com.example.leetcode.medium.frequencyCount.MaxNumCoins;
import com.example.leetcode.medium.stack.ReorderList;
import com.example.leetcode.medium.stack.ValidWord;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class MediumTest {

    @Test
    public void maxNumCoinsTest() {
        MaxNumCoins coins = new MaxNumCoins();
        Assertions.assertEquals(9, coins.maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        Assertions.assertEquals(4, coins.maxCoins(new int[]{2, 4, 5}));
        Assertions.assertEquals(18, coins.maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
    }

    @Test
    public void ArithmeticSubarraysTest() {

        int[] nums = new int[]{4, 6, 5, 9, 3, 7};
        int[] l = new int[]{0, 0, 2};
        int[] r = new int[]{2, 3, 5};
        List<Boolean> result = new ArrayList<>();
        result.add(true);
        result.add(false);
        result.add(true);
        ArithmeticSubarrays subarrays = new ArithmeticSubarrays();
        Assertions.assertEquals(result, subarrays.checkArithmeticSubarrays(nums, l, r));
    }

    @Test
    public void validWordTest() {
        ValidWord validWord = new ValidWord();
        Assertions.assertTrue(validWord.isValid("aabcbc"));
        Assertions.assertFalse(validWord.isValid("aabccc"));
        Assertions.assertFalse(validWord.isValid("aaabc"));

    }

    @Test
    public void reorderListTest() {

        ReorderList.ListNode node5 = new ReorderList.ListNode(5);
        ReorderList.ListNode node4 = new ReorderList.ListNode(4, node5);
        ReorderList.ListNode node3 = new ReorderList.ListNode(3, node4);
        ReorderList.ListNode node2 = new ReorderList.ListNode(2, node3);
        ReorderList.ListNode node1 = new ReorderList.ListNode(1, node2);

        ReorderList list = new ReorderList();
        list.reorderList(node1);

    }

}
