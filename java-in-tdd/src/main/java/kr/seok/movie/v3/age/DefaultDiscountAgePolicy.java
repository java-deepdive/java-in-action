package kr.seok.movie.v3.age;

import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Reservation;
import kr.seok.movie.v3.Screening;

import java.util.List;

public abstract class DefaultDiscountAgePolicy implements DiscountAgePolicy {
	private final List<DiscountAgeCondition> conditions;
	
	protected DefaultDiscountAgePolicy(DiscountAgeCondition... conditions) {
		this.conditions = List.of(conditions);
	}
	
	@Override
	public Money calculateDiscountAmount(Reservation customer) {
		for (DiscountAgeCondition each : conditions) {
			if (each.isSatisfiedBy(customer.getCustomer())) {
				return getDiscountAmount(customer.getScreening());
			}
		}
		return Money.ZERO;
	}
	
	protected abstract Money getDiscountAmount(Screening customer);
}
