package com.techlabs.tictactoeapplication;

public class TicTacToeApplication {

	public static void main(String[] args) {
		Board board = new Board();
		board.printBoard();

        try {
            board.setCellMark(0, 0, MarkType.X);
            board.setCellMark(0, 1, MarkType.O);
            board.setCellMark(0, 2, MarkType.X);
            board.setCellMark(1, 0, MarkType.X);
            board.setCellMark(1, 1, MarkType.O);
            board.setCellMark(1, 2, MarkType.X);
            board.setCellMark(2, 0, MarkType.X);
            board.setCellMark(2, 1, MarkType.O);
           // board.setCellMark(2, 2, MarkType.X);
           board.setCellMark(1, 1, MarkType.O); 
        } catch (CellAlreadyMarkedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Is board full? " + board.isBoardFull());
        board.printBoard();
    }
	
}
