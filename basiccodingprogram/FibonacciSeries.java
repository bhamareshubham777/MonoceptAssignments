package com.techlabs.assignments.basiccodingprogram;

import java.util.Scanner;

public class FibonacciSeries {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("How Many numbers you want fibonacci series?");
		int numberCount=scanner.nextInt();
		
		printFibonacci(numberCount);
	}

	private static void printFibonacci(int numberCount) {
		int number1=0, number2=1, number3=0;
		
        for (int i=0 ; i<numberCount ; i++){
            System.out.print(number1+" ");
            number3=number1+number2;
            number1=number2;
            number2=number3;
        }
	}
}
