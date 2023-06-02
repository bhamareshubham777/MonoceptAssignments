package com.techlabs.carassignment;

import java.util.Scanner;

public class TestVehicle {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter How Many Cars Details You Want:");
		int noOfCars=scanner.nextInt();
		
		Car cars[]=new Car[noOfCars];
		
		acceptCarDetils(cars, scanner);
		displayCarDetails(cars);
	}

	private static void acceptCarDetils(Car[] cars, Scanner scanner) {
		System.out.println("Enter Car Details: ");
		System.out.println();
		
		for(int i=0 ; i<cars.length ; i++) {
			System.out.println("Enter Company Name: ");
			String carName=scanner.next();
			
			System.out.println("Enter Millege: ");
			int millege=scanner.nextInt();
			
			System.out.println("Enter Price: ");
			double carPrice=scanner.nextDouble();
			
			cars[i]=new Car(carName,millege,carPrice);
		}
	}
	
	private static void displayCarDetails(Car[] cars) {
		System.out.println("Car Details: ");
		System.out.println();
		System.out.println("Company \tMillege \tPrice");
		System.out.println("================================");
		
		for(int i=0 ; i<cars.length ; i++) {
			String companyName=cars[i].getCompanyName();
			int millege=cars[i].getMillege();
			double carPrice=cars[i].getCarPrice();
			
			System.out.println(companyName+" \t"+millege+" \t"+carPrice);
		}
		
	}

}
