package com.java.second;

public class TV extends Product {
	private int tvInch;
	private String displayType;
	
	public TV(int productNum, String productName, int price, int quantity, int tvInch, String displayType) {
		super(productNum, productName, price, quantity);
		this.tvInch = tvInch;
		this.displayType = displayType;
	}
	
	public TV() {
		
	}

	public int getTvInch() {
		return tvInch;
	}

	public void setTvInch(int tvInch) {
		this.tvInch = tvInch;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%-10d|%-10s", tvInch, displayType);
	}


}
