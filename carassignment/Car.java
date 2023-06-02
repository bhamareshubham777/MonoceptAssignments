package com.techlabs.carassignment;

public class Car extends FourWheeler{
	private double carPrice;

	public Car() {
		
	}

	public Car( String companyName,int millege,double carPrice) {
		super(companyName,millege);
		this.carPrice = carPrice;
	}

	public double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	
}
