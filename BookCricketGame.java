package com.techlabs.files;

import java.util.Random;

public class BookCricketGame {
	private static int totalPages = 300, pageNumber=0;
    private static int turnsPlayer1 = 0, turnsPlayer2 = 0;
    private static int scorePlayer1 = 0, scorePlayer2 = 0;;
    
    public static void main(String[] args) {
        Random random = new Random();

        turnOfPlayer1(random);
        turnOfPlayer2(random);
        decideWinner();
        
    }

	private static void turnOfPlayer1(Random random) {
        pageNumber = random.nextInt(totalPages) + 1;
        System.out.println("Player 1's turn: ");
        System.out.println("Page number: " + pageNumber);

        while (pageNumber % 7 != 0) {
            int score = pageNumber % 7;
            scorePlayer1 += score;
            turnsPlayer1++;

            System.out.println("Score: " + score);
            System.out.println("Total score: " + scorePlayer1);

            pageNumber = random.nextInt(totalPages) + 1;
            System.out.println("Page number: " + pageNumber);
        }

        System.out.println("Player 1's turn ends.");
        System.out.println("Player 1's total score: " + scorePlayer1);
		
	}
	
	private static void turnOfPlayer2(Random random) {
        pageNumber = random.nextInt(totalPages) + 1;
        System.out.println("Player 2's turn: ");
        System.out.println("Page number: " + pageNumber);

        while (pageNumber % 7 != 0) {
            int score = pageNumber % 7;
            scorePlayer2 += score;
            turnsPlayer2++;

            System.out.println("Score: " + score);
            System.out.println("Total score: " + scorePlayer2);

            pageNumber = random.nextInt(totalPages) + 1;
            System.out.println("Page number: " + pageNumber);
        }

        System.out.println("Player 2's turn ends.");
        System.out.println("Player 2's total score: " + scorePlayer2);	
	}
	
	private static void decideWinner() {
		if (scorePlayer1 > scorePlayer2) {
            System.out.println("Player 1 wins!");
        } else if (scorePlayer2 > scorePlayer1) {
            System.out.println("Player 2 wins!");
        } else {
         
            if (turnsPlayer1 < turnsPlayer2) {
                System.out.println("Player 1 wins!");
            } else if (turnsPlayer2 < turnsPlayer1) {
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("It's a tie!");
            }
        }
	}

}	