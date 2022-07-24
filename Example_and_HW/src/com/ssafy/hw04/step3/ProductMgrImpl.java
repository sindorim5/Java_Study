package com.ssafy.hw04.step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {
	private ArrayList<Product> productList;

	private static IProductMgr instance;

	public static IProductMgr getInstance() {
		if (instance == null) {
			instance = new ProductMgrImpl();
		}
		return instance;
	}

	private ProductMgrImpl() {
		System.out.println("********************불러온 상품 전체 목록********************");
		Thread t = new Thread(() -> {
			loadData();
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void loadData() {
		File loadTarget = new File("product.dat");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadTarget));
			Object readed = null;
			readed = ois.readObject();
			// readed를 불러온 경우
			if (readed != null && readed instanceof ArrayList) {
				productList = (ArrayList<Product>) readed;
				// product.dat은 있는데 등록된 제품이 없는 경우
				if (productList.size() == 0) {
					System.out.println("등록된 제품이 없습니다.");
				} else { // product.dat 있고 등록된 제품도 있는 경우
					for (Product p : productList) {
						if (p != null) {
							System.out.println(p);
						}
					}
				}
			} else { // readed가 null, 불러오지 못한 경우엔 초기화
				System.out.println("등록된 제품이 없습니다.");
				productList = new ArrayList<Product>();
			}
			ois.close();
		} catch (FileNotFoundException e) {
			// product.dat이 존재하지 않는 경우
			System.out.println("등록된 제품이 없습니다.");
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveData() {
		File saveTarget = new File("product.dat");
		// productList가 null이면 초기화
		if (productList == null) {
			productList = new ArrayList<Product>();
		}
		ArrayList<Product> saveProductList = productList;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveTarget));
			oos.writeObject(saveProductList);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addProduct(Product prd) {
		// 처음보는 상품일 때만 저장, searchByProductNum을 하면 에러가 나와서 새로 작성
		Product tempP = new Product();
		for (int i = 0; i < productList.size(); i++) {
			if (prd.getProductNum() == productList.get(i).getProductNum()) {
				tempP = productList.get(i);
				break;
			}
		}
		if (tempP.getProductName() == null) {
			productList.add(prd);
		}
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
	public Product searchByProductNum(int prdNum) throws ProductNotFoundException {
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
