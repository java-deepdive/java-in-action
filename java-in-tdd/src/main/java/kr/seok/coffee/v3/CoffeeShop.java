package kr.seok.coffee.v3;

import kr.seok.coffee.v3.domain.Money;
import kr.seok.coffee.v3.domain.Coffee;
import kr.seok.coffee.v3.order.NoneDiscountPolicy;

public class CoffeeShop {
	
	/**
	 * 1. 쿠폰 사용 여부
	 * 2. 쿠폰 사용 및 주문 내역 출력
	 *
	 * @param name
	 * @param price
	 */
	public void order(String name, int price) {
		
		Coffee coffee = new Coffee(name, Money.wons(15000), new NoneDiscountPolicy());
	}
	
	public void findCoupon(String phoneNumber) {
	}
	
	public void printOrder() {
	}
}
