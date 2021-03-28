package kr.seok.movie.policy;

import kr.seok.movie.Money;
import kr.seok.movie.Screening;
import kr.seok.movie.condition.DiscountCondition;

public class AmountDiscountPolicy extends DiscountPolicy {
    private final Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
