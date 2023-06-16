package com.techlabs.assignment;

public class Country {

	private String abbreviation;
	private String countryName;
	private int regionID;
	
	public Country(String abbreviation, String countryName, int regionID) {
		super();
		this.abbreviation = abbreviation;
		this.countryName = countryName;
		this.regionID = regionID;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getCountryName() {
		return countryName;
	}

	public int getRegionID() {
		return regionID;
	}

	@Override
	public String toString() {
		return "Country [abbreviation=" + abbreviation + ", countryName=" + countryName + ", regionID=" + regionID
				+ "]";
	}
}
