package kr.seok.movie.responsibility.condition;

import kr.seok.movie.responsibility.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
