package tests;

import com.tictactoe.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SessionTest {

    @Test
    public void playerInput() {
        Session s = new Session();
        Player p = new Player("X");
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        int move = s.fetchInput(p);

        assertEquals(1, move);
    }

    @Test
    public void switchTurns() {
        Session s = new Session();

        s.switchTurns();

        assertEquals(s.getCurrentTurn(), s.getComputer());
    }
}