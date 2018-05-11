package tests;

import com.tictactoe.Board;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void create() {
        Board b = new Board();
        assertArrayEquals(b.getSpaces(), new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
    }

    @Test
    public void boardIsFull() {
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

        int n = b.getNumSpacesAvailable();
        assertEquals(0, n);
    }

    @Test
    public void updateBoard() {
        Board b = new Board();
        String[] spaces = b.getSpaces();

        b.update(1, "O");

        assertEquals("O", spaces[0]);
    }

    @Test
    public void updateCannotChangeOccupiedSpace() {
        Board b = new Board();
        String[] spaces = b.getSpaces();

        b.update(1, "O");
        b.update(1, "X");

        assertEquals("O", spaces[0]);
    }

    @Test
    public void fetchSpacesAvailable() {
        Board b = new Board();

        b.update(1, "O");
        b.update(2, "X");

        Set<Integer> set = b.getSpacesAvailable();
        Set<Integer> ans = new HashSet<>();

        for (int i = 3; i <= b.getSpaces().length; i++) {
            ans.add(i);
        }

        assertEquals(ans, set);
    }
}
