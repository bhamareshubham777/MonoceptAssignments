package com.techlabs.assignment2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessApplication {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		int actualNumber=random.nextInt(100);
		System.out.println(actualNumber);
		int totalAttepmts=10;
		boolean status=false;
		
		System.out.println("GUESS THE NUMBER IN 10 TRIALS");
		for(int i=1 ; i<=totalAttepmts ; i++) {
			if(!status) {
				System.out.println("ENTER GUESS NUMBER: ");
				int guessNumber=scanner.nextInt();
			
				if(guessNumber < actualNumber) {
					System.out.println("SORRY, TOO LOW...Try again...!!");
				}else if(guessNumber > actualNumber) {
					System.out.println("SORRY, TOO HIGH...Try again...!!");
				}else {
					System.out.println("YES..You guess the number correctly in no of "+i+" trials.");
					status=true;
					System.out.println("DO YOU WANT TO PLAY AGAIN...1:YES \t 2:NO");
					int choice=scanner.nextInt();
					if(choice==1) {
						status=false;
					}else if(choice==2) {
						System.exit(0);;
					}
				}
			}
		}	
	}
}
