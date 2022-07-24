package com.java.second;

public class Product {
	private int productNum;
	private String productName;
	private int price;
	private int quantity;
	
	public Product() {

	}

	public Product(int productNum, String productName, int price, int quantity) {
		this.productNum = productNum;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("%-10d|%-15s|%-10d|%-10d|", productNum, productName, price, quantity);
	}

}
