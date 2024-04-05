package com.example.algorithms;

import java.util.*;

public class DynamicProgramming {
    public int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public double fibonacci(int n, Map<Integer, Double> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 2) {
            return 1;
        }
        double val = fibonacci(n - 1, map) + fibonacci(n - 2, map);
        map.put(n, val);
        return val;
    }

    public int gridTraveller(int row, int column, Map<String, Integer> map) {
        // key == concat row & column
        String key = row + "," + column;
        String key1 = column + "," + row;
        if (map.containsKey(key))
            return map.get(key);
        if (map.containsKey(key1))
            return map.get(key1);
        if (row == 1 && column == 1)
            return 1;
        if (row == 0 || column == 0)
            return 0;
        int val = gridTraveller(row - 1, column, map) + gridTraveller(row, column - 1, map);
        map.put(key, val);
        return val;
    }

    public boolean canSum(int targetSum, int[] numArr) {
        return canSum(targetSum, numArr, new HashMap<>());
    }

    public boolean canSum(int targetSum, int[] numArr, Map<Integer, Boolean> map) {
        if (map.containsKey(targetSum))
            return map.get(targetSum);

        if (targetSum == 0)
            return true;

        if (targetSum < 0)
            return false;

        // for every element in the numArr
        for (int num : numArr) {
            int remainder = targetSum - num;
            if (canSum(remainder, numArr, map)) { // as long as it returns true, can break out early
                map.put(targetSum, true);
                return true;
            }
        }
        // none of the possibilities returned true so we return false
        map.put(targetSum, false);
        return false;
    }

    public List<Integer> howSum(int targetSum, int[] numArr) {

        if (targetSum == 0)
            return new ArrayList<>();

        // INVALID CASE SO RETURN NULL
        if (targetSum < 0)
            return null;

        List<Integer> list = null;

        for (int num : numArr) {

            int remainder = targetSum - num;

            list = howSum(remainder, numArr);

            if (list != null) {
                list.add(num);
                return list;
            }

        }

        return list;
    }


}
