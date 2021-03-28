package kr.seok.movie.policy;

import kr.seok.movie.Money;
import kr.seok.movie.Screening;
import kr.seok.movie.condition.DiscountCondition;

public class AmountDefaultDiscountPolicy extends DefaultDiscountPolicy {
    private final Money discountAmount;

    public AmountDefaultDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
