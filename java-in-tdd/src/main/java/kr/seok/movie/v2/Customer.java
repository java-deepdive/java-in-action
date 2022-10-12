package kr.seok.movie.v2;

import kr.seok.movie.v3.DiscountAgePolicy;

import java.util.Objects;

public class Customer {
	private final int age;
	
	public Customer(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Customer)) return false;
		Customer customer = (Customer) o;
		return age == customer.age;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age);
	}
	
	@Override
	public String toString() {
		return "Customer{" +
			"age=" + age +
			'}';
	}
}
