package com.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class Board {

    private String[] spaces;
    private int numSpacesAvailable;

    public Board() {
        spaces = this.createBoard();
        numSpacesAvailable = spaces.length;
    }

    public String[] getSpaces() {
        return this.spaces;
    }
    public int getNumSpacesAvailable() { return this.numSpacesAvailable; }

    private String[] createBoard() {
        int len = 9;
        String[] spaces = new String[len];
        for (int i = 0; i < len; i++) {
            spaces[i] = Integer.toString(i+1);
        }
        return spaces;
    }

    public boolean update(int n, String token) {
        if (isAvailable(n)) {
            spaces[n - 1] = token;
            numSpacesAvailable--;
            return true;
        }
        else {
            System.out.println("Error: Space already taken");
            return false;
        }
    }

    private boolean isAvailable(int n) {
        return !spaces[n - 1].equals("X") && !spaces[n - 1].equals("O");
    }

    public Set<Integer> getSpacesAvailable() {
        Set<Integer> spacesAvailable = new HashSet<>();
        for (int i = 1; i <= spaces.length; i++) {
            if (isAvailable(i)) spacesAvailable.add(i);
        }
        return spacesAvailable;
    }
}
