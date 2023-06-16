package com.techlabs.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RegionCountryApp {

	private static int count;

	public static void main(String[] args) {
		List<Region> regions=new ArrayList<Region>();
		regions.add(new Region(1, "Europe"));
		regions.add(new Region(2, "Americas"));
		regions.add(new Region(3, "Asia"));
		regions.add(new Region(4, "Middle East and Africa"));
		
		List<Country> countries=new ArrayList<Country>();
		countries.add(new Country("IT", "Italy", 1));
		countries.add(new Country("JP", "Japan", 3));
		countries.add(new Country("US", "United States of America", 2));
		countries.add(new Country("CA", "Canada", 2));
		countries.add(new Country("CN", "China", 3));
		countries.add(new Country("IN", "India", 3));
		countries.add(new Country("AU", "Australia", 3));
		countries.add(new Country("ZW", "Zimbabwe", 4));
		countries.add(new Country("SG", "Singapore", 3));
		countries.add(new Country("UK", "United Kingdom", 1));
		countries.add(new Country("FR", "France", 1));
		countries.add(new Country("DE", "Germany", 1));
		countries.add(new Country("ZM", "Zambia", 4));
		countries.add(new Country("EG", "Egypt", 4));
		countries.add(new Country("BR", "Brazil", 2));
		countries.add(new Country("CH", "Switzerland", 1));
		countries.add(new Country("NL", "Netherlands", 1));
		countries.add(new Country("MX", "Mexico", 2));
		countries.add(new Country("KW", "Kuwait", 4));
		countries.add(new Country("IL", "Israel", 4));
		countries.add(new Country("DK", "Denmark", 1));
		countries.add(new Country("HK", "HongKong", 3));
		countries.add(new Country("NG", "Nigeria", 4));
		countries.add(new Country("AR", "Argentina", 2));
		countries.add(new Country("BE", "Belgium", 1));
		
		regionwiseCountries(regions,countries);
		countOfCountries(regions,countries);
		countriesByRegionId(regions,countries);
	}

	private static void regionwiseCountries(List<Region> regions, List<Country> countries) {
		regions.stream().forEach(region->{
			System.out.println(region.getId()+" : "+region.getName());
			System.out.println("------------------------------------");
		countries.stream()
		.filter(country->country.getRegionID()==region.getId())
		.forEach(country->System.out.println(country.getCountryName()));
		System.out.println();});	
	}
	
	private static void countOfCountries(List<Region> regions, List<Country> countries) {
		regions.stream().forEach(region->{
			System.out.println(region.getId()+" : "+region.getName());
			System.out.println("------------------------------------");
		countries.stream()
		.filter(country->country.getRegionID()==region.getId())
		.forEach(country-> count++);
		System.out.println(count);
		count=0;
		System.out.println();});	
	}
	
	private static void countriesByRegionId(List<Region> regions, List<Country> countries) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter RegionId to find the countries:");
		System.out.println("Select Region Id Between : 1 / 2 / 3 / 4");
		int regionId=scanner.nextInt();
		
		System.out.println("Countries Of Region Id "+regionId+" are");
			
		countries.stream()
		.filter(country->country.getRegionID()==regionId)
		.forEach(country->System.out.println(country.getCountryName()));
		System.out.println();
	}
}
