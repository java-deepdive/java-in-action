package kr.seok.movie.responsibility.policy;

import kr.seok.movie.responsibility.Money;
import kr.seok.movie.responsibility.Screening;
import kr.seok.movie.responsibility.condition.DiscountCondition;

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
