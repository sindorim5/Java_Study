package com.ssafy.hw03.step3;

import java.util.ArrayList;


public class ProductMgrImpl implements IProductMgr {
	private ArrayList<Product> productList;

	public ProductMgrImpl() {
		productList = new ArrayList<>();
	}

	public void addProduct(Product prd) {
		productList.add(prd);
	}

	public void deleteProduct(int prdNum) throws ProductNotFoundException {
		Product p = searchByProductNum(prdNum);
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).equals(p)) {
				productList.remove(i);
			}
		}
	}

	public void updateProduct(int prdNum, int price) throws ProductNotFoundException {
		Product updatePrd = searchByProductNum(prdNum);
		updatePrd.setPrice(price);
	}

	// 전체 상품 리스트
	public ArrayList<Product> getProductList() {
		return productList;
	}

	// TV 상품 리스트
	public ArrayList<TV> getTVList() {
		ArrayList<TV> searchList = new ArrayList<TV>();
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i) instanceof TV) {
				searchList.add((TV) productList.get(i));
			}
		}
		return searchList;
	}

	// 냉장고 상품 리스트
	public ArrayList<Refrigerator> getRefrigeratorList() {
		ArrayList<Refrigerator> searchList = new ArrayList<Refrigerator>();
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i) instanceof Refrigerator) {
				searchList.add((Refrigerator) productList.get(i));
			}
		}
		return searchList;
	}

	// 일반 상품 리스트
	public ArrayList<Product> getList() {
		ArrayList<Product> searchList = new ArrayList<Product>();
		for (int i = 0; i < productList.size(); i++) {
			if (!(productList.get(i) instanceof TV) && !(productList.get(i) instanceof Refrigerator)) {
				searchList.add(productList.get(i));
			}
		}
		return searchList;
	}
	
	// 상품번호로 상품 찾기
	public Product searchByProductNum(int prdNum) throws ProductNotFoundException{
		for (int i = 0; i < productList.size(); i++) {
			if (prdNum == productList.get(i).getProductNum()) {
				return productList.get(i);
			}
		}
		throw new ProductNotFoundException(prdNum);
	}

	// 상품이름으로 상품 찾기
	public ArrayList<Product> searchByName(String prdName) throws ProductNotFoundException {
		ArrayList<Product> searchList = new ArrayList<Product>();
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getProductName().contains(prdName)) {
				searchList.add(productList.get(i));
			}
		}
		return searchList;
	}
	
	// 검색 냉장고 용량 이상 상품 리스트
	public ArrayList<Refrigerator> searchByCapacity(int capacity) {
		ArrayList<Refrigerator> fridgeList = getRefrigeratorList();
		ArrayList<Refrigerator> searchList = new ArrayList<Refrigerator>();
		for (int i = 0; i < fridgeList.size(); i++) {
			if (fridgeList.get(i).getCapacity() >= capacity) {
				searchList.add(fridgeList.get(i));
			}
		}
		return searchList;
	}
	
	// 검색 TV인치 이상 상품 리스트
	public ArrayList<TV> searchByInch(int inch) {
		ArrayList<TV> tvList = getTVList();
		ArrayList<TV> searchList = new ArrayList<TV>();
		for (int i = 0; i < tvList.size(); i++) {
			if (tvList.get(i).getTvInch() >= inch) {
				searchList.add(tvList.get(i));
			}
		}
		return searchList;
	}
	
	// 전체 재고 상품 금액 구하기
	public int getAllPrice() {
		int sum = 0;
		for (int i = 0; i < productList.size(); i++) {
			sum += productList.get(i).getPrice() * productList.get(i).getQuantity();
		}
		return sum;
	}
	
	// 전체 재고 상품 수 구하기
	public int getAllQuantity() {
		int sum = 0;
		for (int i = 0; i < productList.size(); i++) {
			sum += productList.get(i).getQuantity();
		}
		return sum;
	}
	
	// 전체 재고 상품 금액 평균
	public double getPriceAvg() {
		int sum = getAllPrice();
		int quantity = getAllQuantity();
		return sum / quantity;
	}
	
	// 상품 판매
	public void sell(int prdNum, int quantity) throws QuantityException, ProductNotFoundException {
		Product productToSell;
		productToSell = searchByProductNum(prdNum);
		int q = productToSell.getQuantity();
		if (quantity > q) {
			throw new QuantityException();
		} else {
			productToSell.setQuantity(q - quantity);
			System.out.println(productToSell);
		}
	}
	
	// 상품 구매
	public void buy(int prdNum, int quantity) throws QuantityException, ProductNotFoundException {
		Product productToBuy;
		productToBuy = searchByProductNum(prdNum);
		int q = productToBuy.getQuantity();
		productToBuy.setQuantity(q + quantity);
		System.out.println(productToBuy);
	}
	
}
