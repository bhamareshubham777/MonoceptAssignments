package com.techlabs.tictactoeapplication;

public class Board {
    private Cell[][] cells;

    public Board() {
        cells = new Cell[3][3];
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    public boolean isBoardFull() {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                if (cells[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setCellMark(int row, int col, MarkType mark) throws CellAlreadyMarkedException {
        cells[row][col].setMark(mark);
    }
    
    public void printBoard() {
    	for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                System.out.print(cells[row][col].getMark()+" ");
            }
            System.out.println();
        }
    }
 
}
