package kr.seok.java8.chicken.v7;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;

import java.util.Optional;

public class ChickenOptional {
	
	public String getOrderChicken(User user) {
		return getUser(user).getOrder()
			.map(Order::getChicken)
			.map(Chicken::getBrand)
			.map(ChickenBrand::getName)
			.orElseThrow(() -> new RuntimeException("주문 정보를 조회할 수 없습니다."));
	}
	
	private static User getUser(User user) {
		return Optional.ofNullable(user)
			.orElseThrow(() -> new RuntimeException("사용자 정보를 조회할 수 없습니다."));
	}
}