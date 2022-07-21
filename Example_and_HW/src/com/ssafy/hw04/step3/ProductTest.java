package com.ssafy.hw04.step3;

import java.util.ArrayList;

public class ProductTest {

    public static void main(String[] args) throws ProductNotFoundException, QuantityException {
        IProductMgr mgr = ProductMgrImpl.getInstance();
        ProductTest test = new ProductTest();
        ArrayList<Product> list = mgr.getProductList();

        Product p1 = new Product(689, "Galaxy S21", 50, 100);
        Product p2 = new Product(456, "Galaxy S22", 99, 150);
        Product p3 = new TV(556, "OLED TV", 140, 50, 80, "OLED");
        Product p4 = new TV(779, "LCD TV", 100, 70, 35, "LCD");
        Product p5 = new TV(779, "SAMSUNG TV", 100, 30, 65, "LED");
        Product p6 = new Refrigerator(321, "DIOS", 119, 40, 324);
        Product p7 = new Refrigerator(232, "BESPOKE", 180, 30, 522);
        Product p8 = new Refrigerator(235, "SAMSUNG", 150, 25, 600);

        // add
        System.out.println();

        mgr.addProduct(p1);
        mgr.addProduct(p2);
        mgr.addProduct(p3);
        mgr.addProduct(p4);
        mgr.addProduct(p5);
        mgr.addProduct(p6);
        mgr.addProduct(p7);
        mgr.addProduct(p8);

        System.out.println("*************************전체상품*************************");
        test.printProductList(list);
        System.out.println();

        mgr.saveData();
//
//		// 상품번호로 상품 찾기
//		System.out.println("*************************상품번호: 456*************************");
//		Product searchByNum = mgr.searchByProductNum(456);
//		System.out.println(searchByNum);
//		System.out.println();
//
//		// 상품이름으로 상품 찾기
//		System.out.println("*************************상품이름: TV*************************");
//		ArrayList<Product> searchByName = mgr.searchByName("TV");
//		test.printProductList(searchByName);
//		System.out.println();
//
//		// TV 상품 리스트
//		System.out.println("*************************    TV    *************************");
//		ArrayList<TV> TVList = mgr.getTVList();
//		test.printProductList(TVList);
//		System.out.println();
//
//		// 냉장고 상품 리스트
//		System.out.println("*************************Refrigerator*************************");
//		ArrayList<Refrigerator> RefrigeratorList = mgr.getRefrigeratorList();
//		test.printProductList(RefrigeratorList);
//		System.out.println();
//
//		// 일반 상품 리스트
//		System.out.println("*************************  일반  *************************");
//		ArrayList<Product> normalList = mgr.getList();
//		test.printProductList(normalList);
//		System.out.println();
//
//		// delete
//		System.out.println("*************************상품번호: 689  삭제*************************");
//		mgr.deleteProduct(689);
//		test.printProductList(mgr.getProductList());
//		System.out.println();
//
//		// update
//		System.out.println("*************************상품번호: 456, 30만원으로 update*************************");
//		mgr.updateProduct(456, 30);
//		test.printProductList(mgr.getProductList());
//		System.out.println();
//
//		// 400L 이상의 냉장고 상품 리스트
//		System.out.println("*************************400L 이상의 냉장고*************************");
//		ArrayList<Refrigerator> sortedFridgeList = mgr.searchByCapacity(400);
//		test.printProductList(sortedFridgeList);
//		System.out.println();
//
//		// 50인치 이상의 냉장고 상품 리스트
//		System.out.println("*************************50인치 이상의 TV*************************");
//		ArrayList<TV> sortedTVList = mgr.searchByInch(50);
//		test.printProductList(sortedTVList);
//		System.out.println();
//
//		// 전체 재고 상품 금액 구하기
//		System.out.println("*************************전체 재고 상품 금액*************************");
//		System.out.println("전체 재고 상품 금액: " + mgr.getAllPrice() + "만원");
//		System.out.println();
//
//		// 전체 재고 상품 평균 구하기
//		System.out.println("*************************전체 재고 상품 금액 평균*************************");
//		System.out.println("전체 재고 상품 금액 평균: " + mgr.getPriceAvg() + "만원");
//		System.out.println();
//
//		// 상품 판매 오류
////		System.out.println("*************************OLED TV 100개 판매*************************");
////		mgr.sell(556, 100);	// QuantityException: 수량이 부족합니다.
////		System.out.println();
//
//		// 상품 판매
//		System.out.println("*************************OLED TV 10개 판매*************************");
//		mgr.sell(556, 10);
//		test.printProductList(mgr.getProductList());
//		System.out.println();
//
//		// 상품 구매
//		System.out.println("*************************OLED TV 100개 구매*************************");
//		mgr.buy(556, 100);
//		test.printProductList(mgr.getProductList());
//		System.out.println();

    }

    public <T> void printProductList(ArrayList<T> pList) {
        for (T p : pList) {
            if (p != null) {
                System.out.println(p);
            }
        }
    }
}
