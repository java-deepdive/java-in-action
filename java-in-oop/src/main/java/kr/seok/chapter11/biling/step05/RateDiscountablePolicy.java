package kr.seok.chapter11.biling.step05;

import kr.seok.chapter10.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {
    private final Money discountAmount;

    public RateDiscountablePolicy(Money discountAmount, RatePolicy next) {
        super(next);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
