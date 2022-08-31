package kr.seok.java8.chicken.v6;

class User {
	private final String name;
	
	private final Order order;
	
	public User(String name, Order order) {
		this.name = name;
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return "User:" + this.name;
	}
}