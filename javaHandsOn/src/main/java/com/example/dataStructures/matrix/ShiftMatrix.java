package com.example.dataStructures.matrix;

import java.io.IOException;
import java.util.Scanner;

/*
SOURCE: https://mycode.prepbytes.com/company-questions/top-25-goldman-sachs-interview-questions-set-1/SHIFT

Shift Matrix
You are given a matrix A of N rows and M columns. The task is to shift the given matrix K times.
In one shift operation:
Element at
A[i][j] moves to A[i][j+1].
Element at A[i][M−1] moves to A[i+1][0].
Element at A[N−1][M−1] moves to A[0][0].

Input Format
The first line of input contains a single integer T - denoting the number of test cases.
Each test case follows:
The first line of each test case contains three integers - N,M and K. N lines follow, each having M space-separated integers.

Output Format:
Print the matrix after performing K shifts.
 */
public class ShiftMatrix {

    public static void main(String args[]) throws IOException {

        //write your code here

        // reminds me of a linked list where I only want to change pointer
        // not really move the elements / do the shift

        Scanner sc = new Scanner(System.in);

        int numTest = sc.nextInt();

        for (int i = 0; i < numTest; i++) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[][] matrix = new int[N][M];

            for (int j = 0; j < N; j++) {

                for (int k = 0; k < M; k++) {
                    matrix[j][k] = sc.nextInt();
                }

            }

            shiftMatrix(N, M, K, matrix);


        }

    }


    static void shiftMatrix(int N, int M, int K, int[][] matrix) {


        K = K % (M * N);

        int[][] result = new int[N][M];

        // for the first element, calculate its position in the matrix
        // remaining will follow after (just fill up)

        int rowNum = 0, colNum = 0;

        while (K != 0) {

            if (colNum < M-1) {
                colNum += 1;
            } else {
                if (rowNum == N - 1) {
                    rowNum = 0;
                } else {
                    rowNum += 1;
                }
                colNum = 0;

            }

            K -= 1;

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                result[rowNum][colNum] = matrix[i][j];

                if (colNum < M-1) {
                    colNum += 1;
                } else {
                    if (rowNum == N - 1) {
                        rowNum = 0;
                    } else {
                        rowNum += 1;
                    }
                    colNum = 0;

                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j]);
                if (j != M - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

    }


}
