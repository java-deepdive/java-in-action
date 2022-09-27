package kr.seok.coffee.v3;

import java.util.Objects;

public class Coffee {
	private final String name;
	private final int price;
	
	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
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
