package tictactoetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

	private Board board;

    @BeforeEach
    void init() {
        board = new Board(3);
    }

    @Test
    void testGetSize() {
        int size = board.getSize();
        assertEquals(3, size);
    }

    @Test
    void testGetCell() {
        Cell cell = board.getCell(0, 0);
        assertNotNull(cell);
    }

    @Test
    void testIsFull() {
        boolean isFull = board.isFull();
        assertFalse(isFull);
    }

    @Test
    void testPrintBoard() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        board.printBoard();

        System.setOut(System.out);

        String expectedOutput = "EMPTY EMPTY EMPTY \n" +
                                "EMPTY EMPTY EMPTY \n" +
                                "EMPTY EMPTY EMPTY \n";
        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);
    }

}
