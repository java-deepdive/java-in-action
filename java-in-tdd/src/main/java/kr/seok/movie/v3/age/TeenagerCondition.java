package kr.seok.movie.v3.age;

import kr.seok.movie.v3.Customer;

public class TeenagerCondition implements DiscountAgeCondition {
	@Override
	public boolean isSatisfiedBy(Customer customer) {
		return customer.getAge() >= 13 && customer.getAge() <= 18;
	}
}
