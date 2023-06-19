package com.techlabs.shoppingcartassignment;

public class Product {
    private int ProductId;
    private String ProductName;
    private double productPrice;
    private double discountPercent;

    public Product(int id, String name, double price, double discountPercent) {
        this.ProductId = id;
        this.ProductName = name;
        this.productPrice = price;
        this.discountPercent = discountPercent;
    }

    public int getId() {
        return ProductId;
    }

    public void setId(int id) {
        this.ProductId = id;
    }

    public String getName() {
        return ProductName;
    }

    public void setName(String name) {
        this.ProductName = name;
    }

    public double getPrice() {
        return productPrice;
    }

    public void setPrice(double price) {
        this.productPrice = price;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
    
    public double calculateDiscountedPrice() {
    	double discountedPrice=0.0;
    	discountedPrice=productPrice*(discountPercent/100);
    	return discountedPrice;
    }
}
