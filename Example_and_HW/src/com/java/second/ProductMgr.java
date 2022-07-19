package com.java.second;

import com.ssafy.ws05.step3.Book;

public class ProductMgr {
	private Product[] productList;
	private int productIdx = 0;

	ProductMgr() {
		productList = new Product[1000];
	}

	public int indexOf(int prdNum) {
		for (int i = 0; i < productList.length; i++) {
			if (prdNum == productList[i].getProductNum()) {
				return i;
			}
		}

		return -1;
	}

	public void addProduct(Product prd) {
		productList[productIdx] = prd;
		productIdx++;
	}

	public void deleteProduct(int prdNum) {
		int index = indexOf(prdNum);
		if (index == -1) {
			System.out.println("Error: Can't find Product");
			return;
		}
		productList[index] = productList[--productIdx];
		productList[productIdx] = null;

	}

	public void updateProduct(Product prd) {
		int index = indexOf(prd.getProductNum());
		if (index == -1) {
			System.out.println("Error: Can't find Product");
			return;
		}
		Product updatePrd = searchProduct(prd.getProductNum());
		updatePrd.setPrice(prd.getPrice());
		updatePrd.setQuantity(prd.getQuantity());

	}

	public Product searchProduct(int prdNum) {
		int index = indexOf(prdNum);
		if (index == -1) {
			System.out.println("Error: Can't find Product");
			return null;
		}
		return productList[index];
	}

	// 전체 상품 리스트
	public Product[] getProductList() {
		return productList;
	}

	// TV 상품 리스트
	public Product[] getTVList() {
		Product[] searchList = new Product[productIdx];
		for (int i = 0; i < productIdx; i++) {
			if (productList[i] instanceof TV) {
				searchList[i] = productList[i];
			}
		}
		return searchList;
	}

	// 냉장고 상품 리스트
	public Product[] getRefrigeratorList() {
		Product[] searchList = new Product[productIdx];
		for (int i = 0; i < productIdx; i++) {
			if (productList[i] instanceof Refrigerator) {
				searchList[i] = productList[i];
			}
		}
		return searchList;
	}

	// 일반 상품 리스트
	public Product[] getList() {
		Product[] searchList = new Product[productIdx];
		for (int i = 0; i < productIdx; i++) {
			if (!(productList[i] instanceof TV) && !(productList[i] instanceof Refrigerator)) {
				searchList[i] = productList[i];
			}
		}
		return searchList;
	}
	
	// 상품번호로 상품 찾기
	public Product searchByProductNum(int prdNum) {
		for (int i = 0; i < productIdx; i++) {
			if (prdNum == productList[i].getProductNum()) {
				return productList[i];
			}
		}
		return null;
	}

	// 상품이름으로 상품 찾기
	public Product[] searchByName(String prdName) {
		Product[] searchedList = new Product[productIdx];
		int searchIndex = 0;
		for (int i = 0; i < productIdx; i++) {
			if (productList[i].getProductName().contains(prdName)) {
				searchedList[searchIndex] = productList[i];
				searchIndex++;
			}
		}
		return searchedList;
	}
	
	// 전체 재고 상품 금액 구하기
	public int getAllPrice(Product[] prdList) {
		int sum = 0;
		for (int i = 0; i < prdList.length; i++) {
			if (prdList[i] != null) {
				sum += prdList[i].getPrice() * prdList[i].getQuantity();
			}
		}
		
		return sum;
	}
	
}
