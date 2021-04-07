package kr.seok.chapter11.biling.step03;

import kr.seok.chapter10.Money;

import java.time.Duration;

public class TaxableRegularPhone extends RegularPhone {
    private double taxRate;

    public TaxableRegularPhone(
            Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public Money calculateFee() {
        Money fee = super.calculateFee();
        return fee.plus(fee.times(taxRate));
    }
}
