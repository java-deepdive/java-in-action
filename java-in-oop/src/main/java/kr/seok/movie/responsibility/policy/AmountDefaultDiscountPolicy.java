package kr.seok.movie.responsibility.policy;

import kr.seok.movie.responsibility.Money;
import kr.seok.movie.responsibility.Screening;
import kr.seok.movie.responsibility.condition.DiscountCondition;

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
