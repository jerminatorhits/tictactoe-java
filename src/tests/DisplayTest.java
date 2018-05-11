package tests;

import com.tictactoe.Board;
import com.tictactoe.Display;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DisplayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void printEmptyBoard() {
        Display d = new Display();
        Board b = new Board();
        Display.print(b);
        assertEquals("\n 1 | 2 | 3 \n" +
                "-----------\n" +
                " 4 | 5 | 6 \n" +
                "-----------\n" +
                " 7 | 8 | 9 \n\n", outContent.toString());
    }

    @Test
    public void printString() {
        Display d = new Display();
        d.messages.put("test1", "test2");
        Display.print("test1");
        assertEquals("test2", outContent.toString());
    }
}