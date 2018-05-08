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
        Display.welcome();
        Display.print(b);
        while (!Rules.gameOver(b)) {
            if (currentTurn.equals(p)) {
                int move = fetchInput(p);
                b.update(move, p.getToken());
            } else {
                int move = fetchInput(c);
//                int move = fetchInput(c);
                b.update(move, c.getToken());
            }
            Display.print(b);
            switchTurns();
        }
        switch (Rules.winner(b)) {
            case "X":
                System.out.println("You Win!");
                break;
            case "O":
                System.out.println("The Computer has won!");
                break;
            default:
                System.out.println("It's a tie!");
                break;
        }
        System.out.println("\nThanks for playing!");
    }

    public int fetchInput(Player p) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.print("Please enter a valid move from 1 to 9: ");
            while (!sc.hasNextInt()) {
                System.out.print("\nInvalid Input. Enter a valid move: ");
                sc.next();
            }
            number = sc.nextInt();
            System.out.println();
        } while (!validMove(number, b));
        return number;
    }

    private int fetchInput(Computer c) {
        return c.randomMove(b);
    }

    private boolean validateInput(Scanner sc) {
        return !sc.hasNextInt();
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

    public void setCurrentTurn(Player p) {
        currentTurn = p;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void switchTurns() {
        currentTurn = currentTurn.getToken().equals(p.getToken()) ? c : p;
    }

    public Player getPlayer() {
        return p;
    }

    public Computer getComputer() {
        return c;
    }
}
