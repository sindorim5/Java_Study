package com.java.second;

public class Refrigerator extends Product {
	private int capacity;

	public Refrigerator(int productNum, String productName, int price, int quantity, int capacity) {
		super(productNum, productName, price, quantity);
		this.capacity = capacity;
	}

	public Refrigerator() {

	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%-10d", capacity);
	}

}
