package kr.seok.movie.condition;

import kr.seok.movie.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
