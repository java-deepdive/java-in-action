package kr.seok.java8.chicken.v6;

class User {
	private final String name;
	
	private Order order;
	
	public User(String name) {
		this.name = name;
	}
	
	public void order(Order order) {
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