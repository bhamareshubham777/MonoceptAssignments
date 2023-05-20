package assignment4;

import java.util.Random;
import java.util.Scanner;

public class PIGDiceGameApplication {
    public static void main(String[] args) {
        int targetScore = 20;
        int totalScore = 0;
        int turnScore = 0;
        int turnCount = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let's Play PIG!");
        System.out.println();

        while (totalScore < targetScore) {
            turnCount++;
            System.out.println("TURN " + turnCount);
            System.out.println();

            boolean turnOver = false;

            while (!turnOver) {
                System.out.print("Roll or hold? (r/h): ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("r")) {
                    int die = random.nextInt(6) + 1;
                    System.out.println("Die: " + die);

                    if (die == 1) {
                        turnScore = 0;
                        turnOver = true;
                        System.out.println("Turn over. No score.");
                    } else {
                        turnScore += die;
                    }
                } else if (choice.equalsIgnoreCase("h")) {
                    totalScore += turnScore;
                    turnOver = true;
                    System.out.println("Score for turn: " + turnScore);
                    System.out.println("Total score: " + totalScore);
                }
            }

            System.out.println();
        }

        System.out.println("You finished in " + turnCount + " turns!");
        System.out.println();
        System.out.println("Game over!");
    }
}

