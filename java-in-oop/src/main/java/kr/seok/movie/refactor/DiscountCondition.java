package kr.seok.movie.refactor;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
