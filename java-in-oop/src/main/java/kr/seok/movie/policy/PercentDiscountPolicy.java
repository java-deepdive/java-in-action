package kr.seok.movie.policy;

import kr.seok.movie.Money;
import kr.seok.movie.Screening;
import kr.seok.movie.condition.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy {
    private final double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
