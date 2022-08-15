package kr.seok.coffee.v2;

import java.util.Objects;

public class Coffee {
	private final String name;
	private final int price;
	public Coffee(MenuItem menuItem) {
		this.name = menuItem.getName();
		this.price = menuItem.price();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Coffee)) return false;
		Coffee coffee = (Coffee) o;
		return Objects.equals(name, coffee.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
