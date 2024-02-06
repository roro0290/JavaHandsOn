package com.example.javaHandsOn.games;

import java.util.*;

/*
The game is entirely in the console
1. Print out the game board - 3 rows & 3 columns = 2d array
2. in games, the computer is always waiting for the user -> while loop
3. keep track of player position & cpu position and do a check for winner
Reference: https://www.youtube.com/watch?v=gQb3dE-y1S4
 */
public class TicTacToe {

    static List<Integer> playerPositions = new ArrayList<>();
    static List<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {

        char[][] gameBoard = createGameBoard();

        printGameBoard(gameBoard);

        boolean condition = true;

        while (condition) {
            Scanner scan = new Scanner(System.in);
            System.out.println("enter your placement (1-9):");

            int playerPosition = scan.nextInt();

            while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
                System.out.println("position taken! Enter a correct position!");
                playerPosition = scan.nextInt();
            }

            placePiece(playerPosition, gameBoard, "player");

            Random rand = new Random();
            int cpuPosition;
            do {
                cpuPosition = rand.nextInt(9) + 1;
            } while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition));

            placePiece(cpuPosition, gameBoard, "cpu"); // you can use AI to generate the position

            printGameBoard(gameBoard);

            String result = checkWinner();
            System.out.println(result);

            if (!result.equals("")) {
                condition = false;
            }
        }

        System.out.println("game end");

    }

    // 2D array is [row][column]
    public static void placePiece(int num, char[][] gameBoard, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            playerPositions.add(num);
            symbol = 'X';
        } else {
            cpuPositions.add(num);
            symbol = 'O';
        }
        switch (num) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    /*
    a 2D array of all the symbols
    depending on the input, we will change the space to a X or O
    there are 5 rows and 5 columns (to account for the symbols that differentiates them)
     */
    public static char[][] createGameBoard() {
        return new char[][]{
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
    }

    /*
    List the winning positions first
    If positions match, then win
     */
    public static String checkWinner() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);
        List<Integer> topCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> bottomCol = Arrays.asList(3, 6, 9);
        List<Integer> crossOne = Arrays.asList(1, 5, 9);
        List<Integer> crossTwo = Arrays.asList(3, 5, 7);

        List<List<Integer>> winnerList = new ArrayList<>();
        winnerList.add(topRow);
        winnerList.add(midRow);
        winnerList.add(bottomRow);
        winnerList.add(topCol);
        winnerList.add(midCol);
        winnerList.add(bottomCol);
        winnerList.add(crossOne);
        winnerList.add(crossTwo);

        for (List<Integer> l : winnerList) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won!";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU wins! Sorry :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "it's a tie!";
            }
        }

        return "";
    }


}
