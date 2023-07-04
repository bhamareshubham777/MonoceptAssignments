package tictactoetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellTest {
    private Cell cell;

    @BeforeEach
    void init() {
        cell = new Cell();
    }

    @Test
    void testIsEmpty() {
        assertTrue(cell.isEmpty());
    }

    @Test
    void testGetMark() {
        MarkType mark = cell.getMark();
        assertEquals(MarkType.EMPTY, mark);
    }

    @Test
    void testSetMark() throws CellAlreadyMarkedException {
        cell.setMark(MarkType.EMPTY);
        MarkType mark = cell.getMark();
        assertEquals(MarkType.EMPTY, mark);
    }

    @Test
    void testSetMarkAlreadyMarked() throws CellAlreadyMarkedException {
        cell.setMark(MarkType.O);

        assertThrows(CellAlreadyMarkedException.class, () -> {
            cell.setMark(MarkType.O);
        });
    }
}

