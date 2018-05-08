package tests;

import com.tictactoe.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void create() {
        Player p = new Player("X");
        String token = p.getToken();
        assertEquals("X", token);
    }
}