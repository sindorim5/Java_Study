package com.ssafy.oop3_7.exception.custom;

public class Test {
	public static void main(String[] args) {
		IBookManager impl = new BookMangaerImpl();	// singleton
		try {
			impl.buy("A1234", 10);
		} catch (QuantityException e) {
			e.printStackTrace();
		}
	}

}

interface IBookManager{
	public void buy(String isbn, int quantity) throws QuantityException;
}

class BookMangaerImpl implements IBookManager {
	
	@Override
	public void buy(String isbn, int quantity) throws QuantityException {
		int count = 1;
		if( quantity > count ) {
			throw new QuantityException("수량 보충 요망...");
		}
		// 보유수량보다 quantity가 적을 경우는 일반적인 로직 수행.
		
	}
	
}

class QuantityException extends Exception {

	private static final long serialVersionUID = 4343005997022018131L;
	
	public QuantityException() {
		super("수량이 부족합니다.");
	}
	
	public QuantityException(String msg) {
		super(msg);
	}
	
	
}

