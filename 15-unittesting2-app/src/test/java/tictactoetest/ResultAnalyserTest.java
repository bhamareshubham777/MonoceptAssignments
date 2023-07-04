package tictactoetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultAnalyserTest {
    private ResultAnalyser resultAnalyser;
    private Board board;

    @BeforeEach
    void init() {
        board = new Board(3);
        resultAnalyser = new ResultAnalyser(board);
    }

    @Test
    void testAnalyzeResult_WinningRow() throws InvalidLocationException, CellAlreadyMarkedException {
        board.getCell(0, 0).setMark(MarkType.X);
        board.getCell(0, 1).setMark(MarkType.X);
        board.getCell(0, 2).setMark(MarkType.X);

        ResultType result = resultAnalyser.analyzeResult(0, 2);
        assertEquals(ResultType.WIN, result);
    }

    @Test
    void testAnalyzeResult_WinningColumn() throws InvalidLocationException, CellAlreadyMarkedException {
        board.getCell(0, 1).setMark(MarkType.O);
        board.getCell(1, 1).setMark(MarkType.O);
        board.getCell(2, 1).setMark(MarkType.O);

        ResultType result = resultAnalyser.analyzeResult(2, 1);
        assertEquals(ResultType.WIN, result);
    }

    @Test
    void testAnalyzeResult_WinningDiagonal() throws InvalidLocationException, CellAlreadyMarkedException {
        board.getCell(0, 0).setMark(MarkType.X);
        board.getCell(1, 1).setMark(MarkType.X);
        board.getCell(2, 2).setMark(MarkType.X);

        ResultType result = resultAnalyser.analyzeResult(2, 2);
        assertEquals(ResultType.WIN, result);
    }

}
