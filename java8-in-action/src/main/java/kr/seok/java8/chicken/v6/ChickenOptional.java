package kr.seok.java8.chicken.v6;

import kr.seok.java8.chicken.Chicken;

// 주문정보 -> 치킨 -> 주문자
public class ChickenOptional {
	
	public String getOrderChicken(User user) {
		Chicken chicken = findOrder(user).getChicken();
		if (chicken == null) {
			throw new RuntimeException("치킨 정보를 조회할 수 없습니다.");
		}
		return chicken.getBrand().name();
	}
	
	public Order findOrder(User user) {
		if (user == null) {
			throw new RuntimeException("사용자 정보를 조회할 수 없습니다.");
		}
		Order order = user.getOrder();
		if (order == null) {
			throw new RuntimeException("주문 정보를 조회할 수 없습니다.");
		}
		return order;
	}
}
