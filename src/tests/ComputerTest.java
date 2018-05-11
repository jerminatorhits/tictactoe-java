package tests;

import com.tictactoe.Board;
import com.tictactoe.Computer;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ComputerTest {

    @Test
    public void create() {
        Computer c = new Computer("O");
        String token = c.getToken();
        assertEquals("O", token);
    }

    @Test
    public void randomMove() {
        Computer c = new Computer("O");
        Board b = new Board();
        String[] spaces = b.getSpaces();
        spaces = new String[]{ "1", "X", "O", "4", "5", "6", "7", "8", "9" };

        Set<Integer> possibleMoves = new HashSet<>();
        for (int i = 1; i <= spaces.length; i++) {
            if (!spaces[i - 1].equals("X") || !spaces[i - 1].equals("O")) possibleMoves.add(i);
        }
        int move = c.randomMove(b);

        assertTrue(possibleMoves.contains(move));
    }
}