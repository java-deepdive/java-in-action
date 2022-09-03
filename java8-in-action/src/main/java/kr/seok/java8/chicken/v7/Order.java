package kr.seok.java8.chicken.v7;

import kr.seok.java8.chicken.Chicken;

import java.util.Objects;
import java.util.Optional;

public class Order {
	private Chicken chicken;

	public void setChicken(Chicken chicken) {
		this.chicken = chicken;
	}
	
	public Chicken getChicken() {
		return Optional.ofNullable(chicken)
			.orElseThrow(() -> new RuntimeException("치킨 정보를 조회할 수 없습니다."));
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Order)) return false;
		Order order = (Order) o;
		return Objects.equals(chicken, order.chicken);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(chicken);
	}
	
	public String toString() {
		return "Order:" + this.chicken;
	}
}
