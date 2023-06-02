package com.techlabs.carassignment;

public class FourWheeler extends Vehicle{
	private int millege;
	
	public FourWheeler() {
		
	}

	public FourWheeler(String companyName, int millege) {
		super(companyName);
		this.millege=millege;
	}

	public int getMillege() {
		return millege;
	}

	public void setMillege(int millege) {
		this.millege = millege;
	}

}
