package com.techlabs.controlstructures;

public class WaterBillCalculator {
	public static void main(String[] args) {
		int numberOfUnits=Integer.parseInt(args[0]);
		int meterCharge=75;
		int totalWaterBill;
		int charge;
		
		if(numberOfUnits<=100)
			charge=numberOfUnits*5;
		else if(numberOfUnits<=250)
			charge=numberOfUnits*10;
		else
			charge=numberOfUnits*20;
		
		totalWaterBill=charge+meterCharge;
		System.out.println("TOTAL BILL AMMOUNT IS: "+totalWaterBill);
	}

}
