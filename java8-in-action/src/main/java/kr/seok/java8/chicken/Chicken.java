package kr.seok.java8.chicken;

import java.util.Objects;

public class Chicken implements Comparable<Chicken> {
	private final ChickenBrand brand;
	private final int price;
	private final String name;
	
	public Chicken(ChickenBrand brand, int price) {
		this(brand, price, "");
	}
	
	public Chicken(ChickenBrand brand, int price, String name) {
		this.brand = brand;
		this.price = price;
		this.name = name;
	}
	
	public ChickenBrand getBrand() {
		return this.brand;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public boolean isMatch(ChickenBrand brand) {
		return this.brand == brand;
	}
	
	@Override
	public int compareTo(Chicken o) {
		return this.price - o.price;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Chicken)) return false;
		Chicken chicken = (Chicken) o;
		return brand == chicken.brand;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(brand);
	}
	
	@Override
	public String toString() {
		return "Chicken{" +
			"brand=" + brand +
			", price=" + price +
			'}';
	}
}
