package kr.seok.coffee.v2;

import java.util.Objects;

public class MenuItem {
	
	private final String name;
	private final int price;
	
	public MenuItem(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int price() {
		return price;
	}
	
	public boolean isMatches(CoffeeType menuName) {
		return name.equals(menuName.name());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MenuItem)) return false;
		MenuItem menuItem = (MenuItem) o;
		return price == menuItem.price
			&& Objects.equals(name, menuItem.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}
	
	@Override
	public String toString() {
		return name + " : " + price;
	}
}
