package kr.seok.movie.refactor;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
    private final DayOfWeek dayOfWeek;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return this.dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek())
                && this.startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0
                && this.endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }
}
