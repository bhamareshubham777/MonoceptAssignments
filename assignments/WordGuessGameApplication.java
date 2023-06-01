package com.techlabs.assignments;

import java.util.Random;
import java.util.Scanner;

public class WordGuessGameApplication {
    private static int maxLives = 5;
    private static int lives;
    private static String word;
    private static char[] blanks;
    private static String[] words = {"virat", "rohit", "hardik", "gill", "ruturaj"}; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        startGame(random);
        traceGame(scanner);
        decideWinner();
    }

    private static void traceGame(Scanner scanner) {
    	 while (lives > 0 && !isWordGuessed()) {
             System.out.println("Word: " + String.valueOf(blanks));
             System.out.println("Lives left: " + lives);
             System.out.print("Guess a letter: ");
             char guess = scanner.next().charAt(0);
             guessLetter(guess);
         }	
	}

	private static void decideWinner() {
    	if (isWordGuessed()) {
            System.out.println("Congratulations! You guessed the word.");
            return;
        } 
        
    	System.out.println("Game over! You ran out of lives.");
	}

	private static void startGame(Random random) {
        lives = maxLives;
        word = generateRandomWord(random);
        System.out.println(word);
        blanks = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            blanks[i] = '_';
        }
    }

    private static String generateRandomWord(Random random) {
        int index = random.nextInt(words.length);
        return words[index];
    }

    private static void guessLetter(char letter) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                blanks[i] = letter;
                found = true;
            }
        }
        if (!found) {
            lives--;
        }
    }

    private static boolean isWordGuessed() {
        for (char blank : blanks) {
            if (blank == '_') {
                return false;
            }
        }
        return true;
    }
}