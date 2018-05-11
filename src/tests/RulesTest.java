package tests;

import com.tictactoe.Board;
import com.tictactoe.Rules;
import org.junit.Test;

import static org.junit.Assert.*;

public class RulesTest {

    @Test
    public void noVerticalWin() {
        Board b = new Board();
        String winner = Rules.verticalWin(b);
        assertEquals("#", winner);
    }

    @Test
    public void verticalWinForX() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces[0] = "X";
        spaces[3] = "X";
        spaces[6] = "X";
        String winner = Rules.verticalWin(b);
        assertEquals("X", winner);
    }

    @Test
    public void verticalWinForO() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces[1] = "O";
        spaces[4] = "O";
        spaces[7] = "O";
        String winner = Rules.verticalWin(b);
        assertEquals("O", winner);
    }

    @Test
    public void verticalWinFalse() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces[1] = "O";
        spaces[4] = "X";
        spaces[7] = "O";
        String winner = Rules.verticalWin(b);
        assertEquals("#", winner);
    }

    @Test
    public void noHorizontalWin() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        String winner = Rules.horizontalWin(b);
        assertEquals("#", winner);
    }

    @Test
    public void horizontalWinForX() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces[0] = "X";
        spaces[1] = "X";
        spaces[2] = "X";
        String winner = Rules.horizontalWin(b);
        assertEquals("X", winner);
    }

    @Test
    public void horizontalWinForO() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces[6] = "O";
        spaces[7] = "O";
        spaces[8] = "O";
        String winner = Rules.horizontalWin(b);
        assertEquals("O", winner);
    }

    @Test
    public void horizontalWinFalse() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces[6] = "O";
        spaces[7] = "#";
        spaces[8] = "X";
        String winner = Rules.horizontalWin(b);
        assertEquals("#", winner);
    }

    @Test
    public void noDiagonalWin() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        String winner = Rules.diagonalWin(b);
        assertEquals("#", winner);
    }

    @Test
    public void diagonalWin() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces[0] = "X";
        spaces[4] = "X";
        spaces[8] = "X";
        String winner = Rules.diagonalWin(b);
        assertEquals("X", winner);
    }

    @Test
    public void noAntiDiagonalWin() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        String winner = Rules.antiDiagonalWin(b);
        assertEquals("#", winner);
    }

    @Test
    public void antiDiagonalWin() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces[2] = "O";
        spaces[4] = "O";
        spaces[6] = "O";
        String winner = Rules.antiDiagonalWin(b);
        assertEquals("O", winner);
    }

    @Test
    public void antiDiagonalWinFalse() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces[2] = "O";
        spaces[4] = "X";
        spaces[6] = "O";
        String winner = Rules.antiDiagonalWin(b);
        assertEquals("#", winner);
    }

    @Test
    public void antiDiagonalWinFalse2() {
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces[0] = "X"; spaces[1] = "O"; spaces[2] = "X";
        spaces[3] = "4"; spaces[4] = "X"; spaces[5] = "6";
        spaces[6] = "O"; spaces[7] = "8"; spaces[8] = "9";
        String winner = Rules.antiDiagonalWin(b);
        assertEquals("#", winner);
    }

    @Test
    public void gameHasWinner() {
        Board b = new Board();
        String[] spaces = b.getSpaces();

        spaces[0] = "O"; spaces[1] = "X"; spaces[2] = "X";
        spaces[3] = "X"; spaces[4] = "O"; spaces[5] = "6";
        spaces[6] = "O"; spaces[7] = "8"; spaces[8] = "O";

        String winner = Rules.winner(b);
        assertEquals("O", winner);
    }

    @Test
    public void gameHasNoWinnerYet() {
        Board b = new Board();
        String[] spaces = b.getSpaces();

        spaces[0] = "O"; spaces[1] = "X"; spaces[2] = "X";
        spaces[3] = "X"; spaces[4] = "X"; spaces[5] = "6";
        spaces[6] = "O"; spaces[7] = "8"; spaces[8] = "O";

        String winner = Rules.winner(b);
        assertEquals("#", winner);
    }

    @Test
    public void gameHasNoWinnerYet2() {
        Board b = new Board();
        String[] spaces = b.getSpaces();

        spaces[0] = "X"; spaces[1] = "X"; spaces[2] = "O";
        spaces[3] = "O"; spaces[4] = "O"; spaces[5] = "X";
        spaces[6] = "X"; spaces[7] = "8"; spaces[8] = "O";

        String winner = Rules.winner(b);
        assertEquals("#", winner);
    }

    @Test
    public void gameIsTie() {
        Board b = new Board();
        String[] spaces = b.getSpaces();

        spaces[0] = "O"; spaces[1] = "X"; spaces[2] = "X";
        spaces[3] = "X"; spaces[4] = "O"; spaces[5] = "O";
        spaces[6] = "O"; spaces[7] = "X"; spaces[8] = "X";

        String winner = Rules.winner(b);
        assertEquals("#", winner);
    }

    @Test
    public void gameIsOver() {
        Board b = new Board();
        String[] spaces = b.getSpaces();

        b.update(1, "O");
        b.update(2, "X");
        b.update(3, "X");
        b.update(4, "X");
        b.update(5, "O");
        b.update(6, "O");
        b.update(7, "O");
        b.update(8, "X");
        b.update(9, "X");

        boolean end = Rules.gameOver(b);
        assertTrue(end);
    }
}
