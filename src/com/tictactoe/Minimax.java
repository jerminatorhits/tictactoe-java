package com.tictactoe;

import java.util.Set;

public class Minimax {

    static Player user = new Computer("O");
    static Player opponent = new Player("X");

    public static int getMinimax(Board b, boolean maximizingPlayer) {
        Set<Integer> possibleMoves = b.getSpacesAvailable();
        int score = Integer.MIN_VALUE;
        String[] spaces = b.getSpaces();
        int move = -1;
        for (int i : possibleMoves) {
            spaces[i - 1] = user.getToken();
            int tempScore = evaluateMove(b, false);
            if (tempScore > score) {
                score = Math.max(score, tempScore);
                move = i;
            }
            spaces[i - 1] = String.valueOf(i);
        }
        return move;
    }

    private static int evaluateMove(Board b, boolean maximizingPlayer) {
        Set<Integer> possibleMoves = b.getSpacesAvailable();

        if (possibleMoves.size() == 0 || score(b) != 0) return score(b);

        String[] spaces = b.getSpaces();

        if (maximizingPlayer) {
            int bestScore = Integer.MIN_VALUE;
            for (int i : possibleMoves) {
                spaces[i - 1] = user.getToken();
                int tempScore = evaluateMove(b, false);
                bestScore = Math.max(bestScore, tempScore);
                spaces[i - 1] = String.valueOf(i);
            }
            return bestScore;
        }
        else {
            int bestScore = Integer.MAX_VALUE;
            for (int i : possibleMoves) {
                spaces[i - 1] = opponent.getToken();
                int tempScore = evaluateMove(b, true);
                bestScore = Math.min(bestScore, tempScore);
                spaces[i - 1] = String.valueOf(i);
            }
            return bestScore;
        }
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
