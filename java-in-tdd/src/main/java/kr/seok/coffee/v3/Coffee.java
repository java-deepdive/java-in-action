package kr.seok.coffee.v3;

import kr.seok.coffee.v3.coupon.BenefitPolicy;
import kr.seok.coffee.v3.money.Money;
import kr.seok.coffee.v3.order.Order;

import java.util.Objects;

public class Coffee {
	private final String name;
	private final Money price;
	private final BenefitPolicy benefitPolicy;
	
	public Coffee(String name, Money price, BenefitPolicy benefitPolicy) {
		this.name = name;
		this.price = price;
		this.benefitPolicy = benefitPolicy;
	}
	
	public Money fee() {
		return price;
	}
	
	public Money calculatorCoffeeFee(Order order) {
		return price.minus(benefitPolicy.calculatorFee(order));
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Coffee)) return false;
		Coffee coffee = (Coffee) o;
		return price == coffee.price
			&& Objects.equals(name, coffee.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}
	
	@Override
	public String toString() {
		return "Coffee{" +
			"name='" + name + '\'' +
			", price=" + price +
			'}';
	}
}
