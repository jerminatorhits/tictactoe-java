package com.tictactoe;

import java.util.*;

public class Computer extends Player {
    public Computer(String token) {
        super(token);
    }

    public int randomMove(Board b) {
        String[] spaces = b.getSpaces();
        Set<Integer> possibleMoves = new HashSet<>();
        for (int i = 1; i <= spaces.length; i++) {
            if (!spaces[i - 1].equals("X") && !spaces[i - 1].equals("O")) possibleMoves.add(i);
        }
        int size = possibleMoves.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for (int index : possibleMoves) {
            if (i == item)
                return index;
            i++;
        }
        return -1;
    }
}
