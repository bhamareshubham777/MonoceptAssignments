package tictactoetest;

public class Board {

	private Cell[][] cells;
    private final int size;

    Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    int getSize() {
        return size;
    }

    Cell getCell(int row, int col) {
        return cells[row][col];
    }

    boolean isFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (cells[row][col].getMark() == MarkType.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    void printBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(cells[row][col].getMark() + " ");
            }
            System.out.println();
        }
    }
}
