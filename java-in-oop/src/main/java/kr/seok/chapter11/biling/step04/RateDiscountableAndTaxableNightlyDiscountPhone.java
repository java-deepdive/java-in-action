package kr.seok.chapter11.biling.step04;

import kr.seok.chapter10.Money;

import java.time.Duration;

public class RateDiscountableAndTaxableNightlyDiscountPhone
        extends RateDiscountableNightlyDiscountPhone {
    private double taxRate;

    public RateDiscountableAndTaxableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount,
                                                          Duration seconds, Money discountAmount, double taxRate) {
        super(nightlyAmount, regularAmount, seconds, discountAmount);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).plus(fee.times(taxRate));
    }
}
