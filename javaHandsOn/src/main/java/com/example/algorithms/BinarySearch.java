package com.example.algorithms;

public class BinarySearch {

    public static void main(String[] args) {

    }

    private static int binarySearch(int[] numbers, int numberToFind) {
        // use 2 pointers - one at the very front and one at the end
        // calculate the middle of those 2
        // move the 2 pointers depending on whether the numberToFind is larger or smaller than the middle

        int L = 0, R = numbers.length - 1, middlePosition, middleNum;

        // L and R will keep going closer to each other until they cross
        while (L <= R) {

            middlePosition = (L + R) / 2;
            middleNum = numbers[middlePosition];

            if (middleNum == numberToFind) {
                return middlePosition;
            }

            // we need to check the left side array
            // move the right pointer to the left of the middle number
            if (numberToFind < middleNum) {
                R = middlePosition - 1;
            } else {
                L = middlePosition + 1;
            }

        }

        return 0;
    }
}
