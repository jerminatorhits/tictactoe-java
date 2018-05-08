package com.tictactoe;

import java.util.Set;

public class Minimax {

    static Player user = new Computer("O");
    static Player opponent = new Player("X");

    public static int getMinimax(Board b, Player p) {
        System.out.println("minimax is played");
        Set<Integer> possibleMoves = b.getSpacesAvailable();

        int move = -1;
        int currentScore = -11;
        String[] spaces = b.getSpaces();
        for (int i : possibleMoves) {
            spaces[i - 1] = p.getToken();
            Player next = (p.getToken() == user.getToken()) ? opponent : user;
            System.out.println(score(b));
            if (currentScore < score(b)) {
                currentScore = Math.max(currentScore, getMinimax(b, next));
                move = i;
            }
            spaces[i - 1] = String.valueOf(i);
        }
        return move;
    }

    public static int score(Board b) {
        if (Rules.winner(b).equals(opponent.getToken())) {
            return -10;
        }
        else if (Rules.winner(b).equals(user.getToken())) {
            return 10;
        }
        else return 0;
    }
}
