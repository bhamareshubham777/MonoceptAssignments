package com.techlabs.assignments.basiccodingprogram;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        long factorial = calculateFactorial(number);
        System.out.println("The factorial of " + number + " is: " + factorial);
    }

    private static long calculateFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
