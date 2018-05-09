package tests;

import com.tictactoe.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimaxTest {

    @Test
    public void minimaxChoosesTopLeftCornerAsFirstMove() {
        Player p = new Player("X");
        Computer c = new Computer("O");
        Minimax m = new Minimax();
        Board b = new Board();

        int move = m.getMinimax(b, true);

        assertEquals(1, move);
    }

    @Test
    public void scoresWinBoard() {
        Player p = new Player("X");
        Computer c = new Computer("O");
        Minimax m = new Minimax();
        Board b = new Board();

        b.update(1, "X");
        b.update(2, "O");
        b.update(3, "X");
        b.update(4, "X");
        b.update(5, "O");
        b.update(7, "O");
        b.update(9, "X");
        b.update(8, "O");

        int points = m.score(b);
        assertEquals(10, points);
    }

    @Test
    public void scoresLoseBoard() {
        Player p = new Player("X");
        Computer c = new Computer("O");
        Minimax m = new Minimax();
        Board b = new Board();

        b.update(1, "X");
        b.update(2, "O");
        b.update(4, "X");
        b.update(8, "O");
        b.update(7, "X");

        int points = m.score(b);
        assertEquals(-10, points);
    }

    @Test
    public void scoresUndecidedBoard() {
        Player p = new Player("X");
        Computer c = new Computer("O");
        Minimax m = new Minimax();
        Board b = new Board();

        b.update(1, "X");
        b.update(2, "O");
        b.update(4, "X");
        b.update(8, "O");

        int points = m.score(b);
        assertEquals(0, points);
    }

    @Test
    public void scoresTieBoard() {
        Player p = new Player("X");
        Computer c = new Computer("O");
        Minimax m = new Minimax();
        Board b = new Board();

        b.update(1, "X");
        b.update(2, "X");
        b.update(3, "O");
        b.update(4, "O");
        b.update(5, "O");
        b.update(6, "X");
        b.update(7, "X");
        b.update(8, "O");
        b.update(9, "X");

        int points = m.score(b);
        assertEquals(0, points);
    }

    @Test
    public void choosesWinningMove() {
        Player p = new Player("X");
        Computer c = new Computer("O");
        Minimax m = new Minimax();
        Board b = new Board();

        b.update(1, "X");
        b.update(2, "X");
        b.update(3, "O");
        b.update(4, "O");
        b.update(5, "O");
        b.update(6, "X");
        b.update(9, "X");

        int move = Minimax.getMinimax(b, true);

        System.out.println(move);
        assertEquals(7, move);
    }

    @Test
    public void choosesWinningMove2() {
        Player p = new Player("X");
        Computer c = new Computer("O");
        Minimax m = new Minimax();
        Board b = new Board();

        b.update(1, "X");
        b.update(2, "O");
        b.update(3, "X");
        b.update(4, "X");
        b.update(5, "O");

        int move = Minimax.getMinimax(b, true);
        assertEquals(8, move);
    }

    @Test
    public void blocksOpponentWinningMove() {
        Player p = new Player("X");
        Computer c = new Computer("O");
        Minimax m = new Minimax();
        Board b = new Board();

        b.update(1, "X");
        b.update(5, "O");
        b.update(7, "X");

        int move = Minimax.getMinimax(b, true);
        assertEquals(4, move);
    }

    @Test
    public void blocksOpponentWinningMove2() {
        Player p = new Player("X");
        Computer c = new Computer("O");
        Minimax m = new Minimax();
        Board b = new Board();

        b.update(1, "X");
        b.update(5, "O");
        b.update(9, "X");
        b.update(2, "O");
        b.update(8, "X");

        int move = Minimax.getMinimax(b, true);
        assertEquals(7, move);
    }
}