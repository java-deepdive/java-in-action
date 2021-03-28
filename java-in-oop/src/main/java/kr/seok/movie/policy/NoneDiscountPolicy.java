package kr.seok.movie.policy;

import kr.seok.movie.Money;
import kr.seok.movie.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
