package kr.seok.coffee.v3.order;

import kr.seok.coffee.v3.domain.Coffee;
import kr.seok.coffee.v3.domain.Money;

import java.util.List;

public class Order {
	private final Customer customer;
	private final List<Coffee> coffee;
	private Money money;
	
	public Order(Customer customer, Coffee... coffee) {
		this.customer = customer;
		this.coffee = List.of(coffee);
	}
	
	public Money takeOut() {
		return getMoney();
	}
	
	private Money getMoney() {
		return coffee.stream()
			.map(Coffee::fee)
			.reduce(Money::plus)
			.orElse(Money.ZERO);
	}
}
