package com.techlabs.controlstructures;

import java.util.Scanner;

public class TreasureHuntApplication {
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to Treasure Island...Your mission is to find the treasure");
		treasureHunt();
	}

	private static void treasureHunt() {
		System.out.println("SELECT YOUR CHOICE: \n 1:left \n 2:right");
		String choice=scanner.next();
		
		if(choice.equalsIgnoreCase("right")) {
			System.out.println("Fall into a hole... GAME OVER!!!");
		}	
		else if(choice.equalsIgnoreCase("left")){
			left();
		}else {
			System.out.println("Fall into a hole... GAME OVER!!!");
		}
		
	}

	private static void left() {
		System.out.println("SELECT YOUR CHOICE: \n 1:swim \n 2:wait");
		String choice2=scanner.next();
		
		if(choice2.equalsIgnoreCase("swim")) {
			System.out.println("Attacked by trout...GAME OVER!!!");
		}else if(choice2.equalsIgnoreCase("wait")) {
			selectDoor();
		}else {
			System.out.println("Attacked by trout...GAME OVER!!!");
		}
		
	}

	private static void selectDoor() {
		System.out.println("SELECT DOOR: \n 1:red \n 2:blue \n 3:yellow");
		String choice3=scanner.next();
		
		if(choice3.equalsIgnoreCase("red")) {
			System.out.println("Burned By Fire ...GAME OVER!!!");
		}else if(choice3.equalsIgnoreCase("blue")) {
			System.out.println("Eaten By Beasts...GAME OVER!!!");
		}else if(choice3.equalsIgnoreCase("yellow")) {
			System.out.println("You Win..!!!");
		
		}else {
			System.out.println("GAME OVER!!!");
		}	
	}
}
