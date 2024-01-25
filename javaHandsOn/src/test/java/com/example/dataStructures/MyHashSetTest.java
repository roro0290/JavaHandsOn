package com.example.dataStructures;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MyHashSetTest {

    @Test
    public void test1() {

        String[] actionList = new String[]{"MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"};
        Integer[] input = new Integer[]{null, 1, 2, 1, 3, 2, 2, 2, 2};
        Boolean[] expected = new Boolean[]{null, null, null, true, false, null, true, null, false};

        int size = actionList.length;
        Boolean[] result = new Boolean[size];
        MyHashSet myHashSet = new MyHashSet();
        for (int i = 0; i < size; i++) {
            String action = actionList[i];
            Integer value = input[i];
                        switch (action) {
                case "MyHashSet":
                    break;
                case "add":
                    myHashSet.add(value);
                    break;
                case "remove":
                    myHashSet.remove(value);
                    break;
                case "contains":
                    result[i] = myHashSet.contains(value);
                    break;
            }
            Assertions.assertEquals(expected[i],result[i]);
        }

    }
}
