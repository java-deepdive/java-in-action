package kr.seok.movie.v3.age;

import kr.seok.movie.v3.Customer;

@FunctionalInterface
public interface DiscountAgeCondition {
	boolean isSatisfiedBy(Customer customer);
	
}
