package tictactoetest;

public class TicTacToeGame {

	public static void main(String[] args) {
        Game game = new Game("Shubham", "Rushi", 3);
        try {
			game.play();
		} catch (InvalidLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
