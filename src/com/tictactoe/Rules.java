package com.tictactoe;

public class Rules {
    public static String verticalWin(Board b) {
        String[] spaces = b.getSpaces();
        int rowLength = (int) Math.sqrt(spaces.length);
        int colLength = rowLength;
        for (int col = 0; col < rowLength; col++) {
            int count = 0;
            for (int row = col; row < spaces.length; row += rowLength) {
                if (spaces[col].equals(spaces[row])) count++;
            }
            if (count == colLength) return spaces[col];
        }
        return "#";
    }

    public static String horizontalWin(Board b) {
        String[] spaces = b.getSpaces();
        int rowLength = (int) Math.sqrt(spaces.length);
        int colLength = rowLength;
        for (int row = 0; row < spaces.length; row += rowLength) {
            int count = 0;
            for (int col = row; col < row + colLength; col++) {
                if (spaces[col].equals(spaces[row])) count++;
            }
            if (count == colLength) return spaces[row];
        }
        return "#";
    }

    public static String diagonalWin(Board b) {
        String[] spaces = b.getSpaces();
        int rowLength = (int) Math.sqrt(spaces.length);
        int topLeftIndex = 0;
        int count = 0;
        for (int index = 0; index < spaces.length; index += rowLength + 1) {
            if (spaces[topLeftIndex].equals(spaces[index])) count++;
        }
        if (count == rowLength) return spaces[topLeftIndex];
        return "#";
    }

    public static String antiDiagonalWin(Board b) {
        String[] spaces = b.getSpaces();
        int rowLength = (int) Math.sqrt(spaces.length);
        int topRightIndex = rowLength - 1;
        int count = 0;
        for (int index = 0; index < spaces.length - rowLength; index += rowLength - 1) {
            if (spaces[topRightIndex].equals(spaces[topRightIndex + index])) count++;
        }
        if (count == rowLength) return spaces[topRightIndex];
        return "#";
    }

    public static String winner(Board b) {
        if (!verticalWin(b).equals("#")) return verticalWin(b);
        if (!horizontalWin(b).equals("#")) return horizontalWin(b);
        if (!diagonalWin(b).equals("#")) return diagonalWin(b);
        return antiDiagonalWin(b);
    }

    public static boolean gameOver(Board b) {
        return !winner(b).equals("#") || b.getNumSpacesAvailable() == 0;
    }
}
