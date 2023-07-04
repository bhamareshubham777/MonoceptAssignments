package tictactoetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void init() {
        player = new Player("Shubham", MarkType.X);
    }

    @Test
    void testGetName() {
        String name = player.getName();
        assertEquals("Shubham", name);
    }

    @Test
    void testGetMark() {
        MarkType mark = player.getMark();
        assertEquals(MarkType.X, mark);
    }
}

