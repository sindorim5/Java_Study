package com.ssafy.hw04.step3;

class ProductNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(int prdNum) {
        System.out.println("ProductNotFoundException: " + prdNum + "상품 정보가 없습니다.");
    }

    public ProductNotFoundException(String prdName) {
        System.out.println("ProductNotFoundException: " + prdName + "상품 정보가 없습니다.");
    }
}