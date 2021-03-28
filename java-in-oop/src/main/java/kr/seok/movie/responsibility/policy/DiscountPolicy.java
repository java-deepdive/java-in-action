package kr.seok.movie.responsibility.policy;

import kr.seok.movie.responsibility.Money;
import kr.seok.movie.responsibility.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
