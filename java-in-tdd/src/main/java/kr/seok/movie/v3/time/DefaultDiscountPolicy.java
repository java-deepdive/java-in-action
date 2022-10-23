package kr.seok.movie.v3.time;

import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Screening;

import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
	private final List<DiscountCondition> conditions;
	
	protected DefaultDiscountPolicy(DiscountCondition... conditions) {
		this.conditions = Arrays.asList(conditions);
	}
	
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		for (DiscountCondition each : conditions) {
			if (each.isSatisfiedBy(screening)) {
				return getDiscountAmount(screening);
			}
		}
		return Money.ZERO;
	}
	
	/**
	 * hoook
	 */
	protected abstract Money getDiscountAmount(Screening screening);
}
