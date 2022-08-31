package kr.seok.java8.chicken.v6;

import kr.seok.java8.chicken.Chicken;

// 주문정보 -> 치킨 -> 주문자
public class ChickenOptional {
	
	public String getOrderChicken(User user) {
		return user.getOrder().getChicken().getBrand().name();
	}
}
