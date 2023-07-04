package tictactoetest;

import java.util.Scanner;

public class Game {

	private Player player1;
    private Player player2;
    private Board board;
    private ResultAnalyser resultAnalyser;
    private Player currentPlayer;

    Game(String player1Name, String player2Name, int boardSize) {
        player1 = new Player(player1Name, MarkType.X);
        player2 = new Player(player2Name, MarkType.O);
        board = new Board(boardSize);
        resultAnalyser = new ResultAnalyser(board);
        currentPlayer = player1;
    }

    void play() throws InvalidLocationException {
        while (true) {
            board.printBoard();
            System.out.println();
            System.out.println(currentPlayer.getName() + "'s turn.");
            int row = getPlayerInput("row");
            int col = getPlayerInput("column");

            try {
                board.getCell(row, col).setMark(currentPlayer.getMark());
                ResultType result = resultAnalyser.analyzeResult(row, col);
                if (result == ResultType.WIN) {
                    board.printBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                } else if (result == ResultType.DRAW) {
                    board.printBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } catch (CellAlreadyMarkedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getPlayerInput(String coordinate) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the " + coordinate + ": ");
        return scanner.nextInt();
    }

}
