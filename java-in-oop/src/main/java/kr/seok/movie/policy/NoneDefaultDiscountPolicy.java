package kr.seok.movie.policy;

import kr.seok.movie.Money;
import kr.seok.movie.Screening;

public class NoneDefaultDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
