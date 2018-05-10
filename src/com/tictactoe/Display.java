package com.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Display {

    private static final Map<String, String> messages = createMap();

    private static Map<String, String> createMap() {
        Map<String,String> map = new HashMap<>();
        map.put("welcome", "Hello! Welcome to TicTacToe! You will be \'X\' and the Computer will be \'O\'. The First player to get 3 in a row wins!\n");
        map.put("playerWin", "You Win!");
        map.put("computerWin", "The Computer has won!");
        map.put("tie", "It's a tie!");
        map.put("gameOver", "\nThanks for playing!");
        map.put("requestMove", "Please enter a valid move from 1 to 9: ");
        map.put("invalidMove", "\nInvalid Input. Enter a valid move: ");
        return map;
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
        String message = messages.get(s);
        System.out.println(message);
    }

}
