package com.techlabs.assignments.basiccodingprogram;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean result=checkPrime(number);
        
        if(result==true) {
        	System.out.println(number+" is Prime");
        }else {
        	System.out.println(number+" is Not Prime");
        }
	}

	private static boolean checkPrime(int number) {
		int count=0;
		
		for(int i=2 ; i<number/2 ; i++) {
			if(number%i == 0) 
				return false;
		}
		return true;
	}

}
