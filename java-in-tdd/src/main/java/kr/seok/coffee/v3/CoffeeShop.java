package kr.seok.coffee.v3;

public class CoffeeShop {
	
	/**
	 * 1. 쿠폰 사용 여부
	 * 2. 쿠폰 사용 및 주문 내역 출력
	 *
	 * @param name
	 * @param price
	 */
	public void order(String name, int price) {
		
		Coffee coffee = new Coffee(name, price);
	}
	
	public void findCoupon(String phoneNumber) {
	}
	
	public void printOrder() {
	}
}
