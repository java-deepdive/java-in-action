package kr.seok.movie.v3.age;

import kr.seok.movie.v3.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountAgeConditionTest {
	
	@DisplayName("Senior 조건 테스트")
	@Test
	void testCase1() {
		// given
		DiscountAgeCondition condition = new DiscountAgeCondition() {
			@Override
			public boolean isSatisfiedBy(Customer customer) {
				return customer.getAge() >= 65;
			}
		};
		
		// when
		boolean satisfiedBy = condition.isSatisfiedBy(new Customer(65));
		
		// then
		assertThat(satisfiedBy).isTrue();
	}
	
	@DisplayName("Teenager 조건 테스트")
	@Test
	void testCase2() {
		// given
		DiscountAgeCondition condition = new DiscountAgeCondition() {
			@Override
			public boolean isSatisfiedBy(Customer customer) {
				return customer.getAge() >= 13 && customer.getAge() <= 19;
			}
		};
		
		// when
		boolean satisfiedBy = condition.isSatisfiedBy(new Customer(13));
		
		// then
		assertThat(satisfiedBy).isTrue();
	}
	
	@DisplayName("일반인 조건 테스트")
	@Test
	void testCase3() {
		// given
		DiscountAgeCondition condition = new DiscountAgeCondition() {
			@Override
			public boolean isSatisfiedBy(Customer customer) {
				return customer.getAge() >= 13 && customer.getAge() <= 19;
			}
		};
		
		// when
		boolean satisfiedBy = condition.isSatisfiedBy(new Customer(20));
		
		// then
		assertThat(satisfiedBy).isFalse();
	}
}