package kr.seok.java8.chicken;

import java.util.Objects;

public class Chicken {
	private final ChickenBrand brand;
	private final int price;
	
	public Chicken(ChickenBrand brand, int price) {
		this.brand = brand;
		this.price = price;
	}
	
	public ChickenBrand getBrand() {
		return this.brand;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Chicken)) return false;
		Chicken chicken = (Chicken) o;
		return price == chicken.price
			&& brand == chicken.brand;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(brand, price);
	}
}
