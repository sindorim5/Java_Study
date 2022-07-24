package com.java.second;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgr mgr = ProductMgr.getInstance();
		ProductTest test = new ProductTest();

		Product p1 = new Product(689, "Galaxy S21", 50, 100);
		Product p2 = new Product(456, "Galaxy S22", 99, 150);
		Product p3 = new TV(556, "OLED TV", 140, 50, 65, "OLED");
		Product p4 = new TV(779, "LCD TV", 100, 70, 65, "LCD");
		Product p5 = new Refrigerator(321, "DIOS", 119, 40, 524);
		Product p6 = new Refrigerator(232, "BESPOKE", 180, 30, 522);
		Product p7 = new Refrigerator(235, "SAMSUNG", 150, 25, 600);

		// add
		mgr.addProduct(p1);
		mgr.addProduct(p2);
		mgr.addProduct(p3);
		mgr.addProduct(p4);
		mgr.addProduct(p5);
		mgr.addProduct(p6);
		mgr.addProduct(p7);

		System.out.println("*************************전체상품*************************");
		test.printProductList(mgr.getProductList());
		System.out.println();

		// 상품번호로 상품 찾기
		System.out.println("*************************상품번호: 456*************************");
		Product searchByNum = mgr.searchByProductNum(456);
		System.out.println(searchByNum);
		System.out.println();

		// 상품이름으로 상품 찾기
		System.out.println("*************************상품이름: TV*************************");
		Product[] searchByName = mgr.searchByName("TV");
		test.printProductList(searchByName);
		System.out.println();

		// TV 상품 리스트
		System.out.println("*************************    TV    *************************");
		Product[] TVList = mgr.getTVList();
		test.printProductList(TVList);
		System.out.println();

		// 냉장고 상품 리스트
		System.out.println("*************************Refrigerator*************************");
		Product[] RefrigeratorList = mgr.getRefrigeratorList();
		test.printProductList(RefrigeratorList);
		System.out.println();

		// 일반 상품 리스트
		System.out.println("*************************  일반  *************************");
		Product[] searchedList = mgr.getList();
		test.printProductList(searchedList);
		System.out.println();

		// delete
		System.out.println("*************************상품번호: 689  삭제*************************");
		mgr.deleteProduct(689);
		test.printProductList(mgr.getProductList());
		System.out.println();

		// update
		System.out.println("*************************update*************************");
		p2.setPrice(30);
		mgr.updateProduct(p2);
		test.printProductList(mgr.getProductList());
		System.out.println();

		// 전체 재고 상품 금액 구하기
		System.out.println("*************************전체 재고 상품 금액*************************");
		System.out.println("전체 재고 상품 금액: " + mgr.getAllPrice(mgr.getProductList()) + "만원");
		System.out.println();

	}

	public void printProductList(Product[] prdList) {
		for (int i = 0; i < prdList.length; i++) {
			if (prdList[i] != null) {
				System.out.println(prdList[i]);
			}
		}
	}

}
