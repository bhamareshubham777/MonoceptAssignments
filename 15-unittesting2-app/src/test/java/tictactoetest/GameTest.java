package tictactoetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class GameTest {
    private Game game;

    @BeforeEach
    void init() {
        game = new Game("Player 1", "Player 2", 3);
    }

    @Test
    void testPlay() throws InvalidLocationException {
        String simulatedInput = "0\n0\n1\n1\n2\n2\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        try {
            game.play();
        } catch (InvalidLocationException e) {
            e.printStackTrace();
        }

        System.setIn(System.in);
        System.setOut(System.out);

        String expectedOutput = "EMPTY EMPTY EMPTY \n" +
                                "EMPTY EMPTY EMPTY \n" +
                                "EMPTY EMPTY EMPTY \n" +
                                "\n" +
                                "Player 1's turn.\n" +
                                "Enter the row: " +
                                "Enter the column: " +
                                "EMPTY EMPTY EMPTY \n" +
                                "EMPTY O EMPTY \n" +
                                "EMPTY EMPTY EMPTY \n" +
                                "\n" +
                                "Player 2's turn.\n" +
                                "Enter the row: " +
                                "Enter the column: " +
                                "EMPTY EMPTY EMPTY \n" +
                                "EMPTY O EMPTY \n" +
                                "EMPTY EMPTY X \n" +
                                "\n" +
                                "Player 1's turn.\n" +
                                "Enter the row: " +
                                "Enter the column: " +
                                "Player 1 wins!\n";

        String actualOutput = outputStream.toString();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}

