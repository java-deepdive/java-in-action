package kr.seok.movie;

import kr.seok.movie.condition.PeriodCondition;
import kr.seok.movie.condition.SequenceCondition;
import kr.seok.movie.policy.AmountDiscountPolicy;
import kr.seok.movie.policy.NoneDiscountPolicy;
import kr.seok.movie.policy.PercentDiscountPolicy;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;

class MovieTest {

    @Test
    void testCase() {
        Movie movie = new Movie(
                "아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                        Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                )
        );
    }

    @Test
    void testCase2() {
        Movie movie = new Movie(
                "타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                new PercentDiscountPolicy(
                        0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
                )
        );
    }

    @Test
    void testCase3() {
        Movie movie = new Movie(
                "스타워즈",
                Duration.ofMinutes(210),
                Money.wons(1000),
                new NoneDiscountPolicy()
        );
    }
}
