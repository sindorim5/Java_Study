package com.ssafy.hw03.step3;

import java.util.ArrayList;

interface IProductMgr {

	abstract void addProduct(Product prd);

	abstract void deleteProduct(int prdNum) throws ProductNotFoundException;

	abstract void updateProduct(int prdNum, int price) throws ProductNotFoundException;

	// 전체 상품 리스트
	abstract ArrayList<Product> getProductList();

	// TV 상품 리스트
	abstract ArrayList<TV> getTVList();

	// 냉장고 상품 리스트
	abstract ArrayList<Refrigerator> getRefrigeratorList();

	// 일반 상품 리스트
	abstract ArrayList<Product> getList();

	// 상품번호로 상품 찾기
	abstract Product searchByProductNum(int prdNum) throws ProductNotFoundException;

	// 상품이름으로 상품 찾기
	abstract ArrayList<Product> searchByName(String prdName) throws ProductNotFoundException;

	// 전체 재고 상품 금액 구하기
	abstract int getAllPrice();

	// 전체 재고 상품 수 구하기
	abstract int getAllQuantity();

	// 전체 재고 상품 금액 평균
	abstract double getPriceAvg();

	// 상품 판매
	abstract void sell(int prdNum, int quantity) throws QuantityException, ProductNotFoundException;

	// 상품 구매
	abstract void buy(int prdNum, int quantity) throws QuantityException, ProductNotFoundException;

}
