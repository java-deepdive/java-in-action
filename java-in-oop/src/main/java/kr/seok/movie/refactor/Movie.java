package kr.seok.movie.refactor;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * 다형성을 통한 low coupling
 */
public abstract class Movie {
    private final String title;
    private final Duration runningTime;
    private final Money fee;
    private List<DiscountCondition> discountConditions;
    private MovieType movieType;
    private double discountPercent;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    protected Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    public void changeDiscountPolicy(DiscountCondition... discountConditions) {
        this.discountConditions = Arrays.asList(discountConditions);
    }

    abstract protected Money calculateDiscountAmount();
}
