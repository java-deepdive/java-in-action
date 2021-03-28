package kr.seok.movie.policy;

import kr.seok.movie.Money;
import kr.seok.movie.Screening;
import kr.seok.movie.condition.DiscountCondition;

public class PercentDefaultDiscountPolicy extends DefaultDiscountPolicy {
    private final double percent;

    public PercentDefaultDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
