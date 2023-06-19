package com.techlabs.shoppingcartassignment;

import java.util.Arrays;
import java.util.List;

public class ShoppingCart {

//	private static double totalCost;
//	private static double lineCost;
	
	public static void main(String[] args) {
		Product product1 = new Product(11, "Books", 250, 20);
		Product product2 = new Product(21, "Pens", 200, 10);
		
		List<LineItem> lineItems=Arrays.asList(new LineItem(1, 2, product1),
												new LineItem(2, 3, product2));
		
		displayDetails(lineItems);
	}

	private static void displayDetails(List<LineItem> lineItems) {
		double lineCost=0.0;
		double totalLineCost=0.0;
		
		System.out.println("Id\tName\t\tQuantity\tUnitPrice\tLineCost");
		System.out.println("==================================================================");
		
		for(LineItem item : lineItems) {
			Product product=item.getProduct();
			lineCost=item.calculateLineItemCost();
			totalLineCost+=lineCost;
			System.out.println(product.getId()+"\t"+product.getName()+"\t\t"+item.getQuantity()+"\t\t"+product.getPrice()+"\t\t"+lineCost);
		}
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t\t\t\t\tTotal Line Cost: "+totalLineCost);
	}
}
