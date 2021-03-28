package kr.seok.movie.policy;

import kr.seok.movie.Money;
import kr.seok.movie.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
