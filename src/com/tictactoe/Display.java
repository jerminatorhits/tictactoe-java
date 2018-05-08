package com.tictactoe;

public class Display {

    public static void welcome() {
        System.out.print("Hello! Welcome to TicTacToe! You will be \'X\' and the Computer will be \'O\'. The First player to get 3 in a row wins!\n");
    }

    public static void print(Board b) {
        String[] spaces = b.getSpaces();
        int rowLength = (int) Math.sqrt(spaces.length);
        int colLength = rowLength;
        System.out.println();
        for (int row = 0; row < spaces.length; row += rowLength) {
            for (int col = row; col < row + colLength; col++) {
                System.out.print(" " + spaces[col] + " ");
                if (col + 1 < row + colLength) System.out.print("|");
            }
            System.out.println();
            if (row + rowLength < spaces.length) {
                for (int i = 0; i < rowLength * 4 - 1; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void print(String s) {
        System.out.print(s);
    }

}
