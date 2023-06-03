package com.techlabs.assignments;

import java.util.Random;
import java.util.Scanner;

public class PIGDiceGameApplicationRefactor {
	private static Random random = new Random();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Let's Play PIG!");
		checkScore();
	}

	private static void checkScore() {
		int targetScore = 20;
		int totalScore = 0;
		int turns = 0;

		while (totalScore < targetScore) {
			turns++;
			System.out.println("TURN " + turns);
	        int turnScore = playTurn();
	        totalScore += turnScore;
		    System.out.println("Score for turn: " + turnScore);
		    System.out.println("Total score: " + totalScore  );
		}

		System.out.println("You finished in " + turns + " turns!");
		System.out.println("Game over!");
			
	}

	private static int playTurn() {
		int turnScore = 0;
	    int die;
	    
	    while (true) {
	    	System.out.print("Roll or hold? (r/h): ");
	        String choice = scanner.nextLine().trim().toLowerCase();

	        if (choice.equals("r")) {
	        	die = rollDie();
	            System.out.println("Die: " + die);
	            turnScore=checkDieForRoll(die,turnScore);
	            break;
	        } 
	        if (choice.equals("h")) {
	            break;
	        }
	    }

	    return turnScore;
	}

	private static int checkDieForRoll(int die, int turnScore) {
		if (die == 1) {
			turnScore = 0;
            System.out.println("Turn over. No score.");
        } 
		turnScore=ifDieNotOne(die,turnScore);
		return turnScore;
	}

	private static int ifDieNotOne(int die, int turnScore) {
		if(die != 1)
			turnScore += die;
		return turnScore;
	}

	private static int rollDie() {
	     return random.nextInt(6) + 1;
	}
	
}

