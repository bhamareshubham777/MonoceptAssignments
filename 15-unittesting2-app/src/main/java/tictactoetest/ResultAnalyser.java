package tictactoetest;

public class ResultAnalyser {

	private Board board;
    private final int size;

    ResultAnalyser(Board board) {
        this.board = board;
        size = board.getSize();
    }

    ResultType analyzeResult(int lastRow, int lastCol) {
        if (isWinningRow(lastRow) || isWinningColumn(lastCol) || isWinningDiagonal(lastRow, lastCol)) {
            return ResultType.WIN;
        } else if (board.isFull()) {
            return ResultType.DRAW;
        }
        return ResultType.PROGRESS;
    }

    private boolean isWinningRow(int row) {
        MarkType mark = board.getCell(row, 0).getMark();
        for (int col = 1; col < size; col++) {
            if (board.getCell(row, col).getMark() != mark) {
                return false;
            }
        }
        return true;
    }

    private boolean isWinningColumn(int col) {
        MarkType mark = board.getCell(0, col).getMark();
        for (int row = 1; row < size; row++) {
            if (board.getCell(row, col).getMark() != mark) {
                return false;
            }
        }
        return true;
    }

    private boolean isWinningDiagonal(int row, int col) {
        if (row == col) {
            MarkType mark = board.getCell(0, 0).getMark();
            for (int i = 1; i < size; i++) {
                if (board.getCell(i, i).getMark() != mark) {
                    return false;
                }
            }
            return true;
        }

        if (row + col == size - 1) {
            MarkType mark = board.getCell(0, size - 1).getMark();
            for (int i = 1; i < size; i++) {
                if (board.getCell(i, size - 1 - i).getMark() != mark) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

}
