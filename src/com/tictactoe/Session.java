package com.tictactoe;

import java.util.Scanner;

public class Session {

    private Board b;
    private Player p;
    private Computer c;
    private Player currentTurn;

    public Session() {
        this.b = new Board();
        this.p = new Player("X");
        this.c = new Computer("O");
        this.currentTurn = p;
    }

    public void start() {
        String[] spaces = b.getSpaces();
        Display.print("welcome");
        Display.print(b);
        while (!Rules.gameOver(b)) {
            if (currentTurn.equals(p)) {
                int move = fetchInput(p);
                b.update(move, p.getToken());
            } else {
                int move = Minimax.getMinimax(b, true);
//                int move = fetchInput(c);
                b.update(move, c.getToken());
            }
            Display.print(b);
            switchTurns();
        }
        endGame(b);
    }

    private void endGame(Board b) {
        switch (Rules.winner(b)) {
            case "X":
                Display.print("playerWin");
                break;
            case "O":
                Display.print("computerWin");
                break;
            default:
                Display.print("tie");
                break;
        }
        Display.print("gameOver");
    }

    public int fetchInput(Player p) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            Display.print("requestMove");
            while (!sc.hasNextInt()) {
                Display.print("invalidMove");
                sc.next();
            }
            number = sc.nextInt();
            System.out.println();
        } while (!validMove(number, b));
        return number;
    }

    private boolean validMove(int n, Board b) {
        return withinBounds(n, b) && spaceAvailable(n, b);
    }

    private boolean withinBounds(int n, Board b) {
        String[] spaces = b.getSpaces();
        return n > 0 && n <= spaces.length;
    }

    private boolean spaceAvailable(int n, Board b) {
        int m = n - 1;
        String[] spaces = b.getSpaces();
        return !spaces[m].equals("X") && !spaces[m].equals("O");
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void switchTurns() {
        currentTurn = currentTurn.getToken().equals(p.getToken()) ? c : p;
    }

    public Computer getComputer() {
        return c;
    }
}
