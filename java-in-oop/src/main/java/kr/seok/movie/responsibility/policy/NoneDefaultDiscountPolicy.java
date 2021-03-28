package kr.seok.movie.responsibility.policy;

import kr.seok.movie.responsibility.Money;
import kr.seok.movie.responsibility.Screening;

public class NoneDefaultDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
