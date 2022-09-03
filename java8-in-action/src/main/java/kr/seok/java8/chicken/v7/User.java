package kr.seok.java8.chicken.v7;

import java.util.Objects;
import java.util.Optional;

public class User {
	private final String name;
	private Order order;
	
	public User(String name) {
		this.name = name;
	}
	
	public void order(Order order) {
		this.order = order;
	}
	
	public Optional<Order> getOrder() {
		return Optional.ofNullable(order);
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return Objects.equals(name, user.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public String toString() {
		return "User{" +
			"name='" + name + '\'' +
			", order=" + order +
			'}';
	}
}
