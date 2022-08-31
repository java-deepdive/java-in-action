package kr.seok.java8.chicken.v6;

import kr.seok.java8.chicken.Chicken;

public class Order {
	private final Chicken chicken;
	
	public Order(Chicken chicken) {
		this.chicken = chicken;
	}
	
	public Chicken getChicken() {
		return this.chicken;
	}
	
	public String toString() {
		return "Order:" + this.chicken;
	}
}