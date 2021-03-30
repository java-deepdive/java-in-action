package kr.seok.movie.refactor;

import java.time.Duration;

public class AmountDiscountMovie extends Movie {

    private final Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime, Money fee,
                               Money discountAmount, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    public Money calculateDiscountAmount() {
        return discountAmount;
    }
}
