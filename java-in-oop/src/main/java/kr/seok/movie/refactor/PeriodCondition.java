package kr.seok.movie.refactor;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return this.dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek())
                && this.startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0
                && this.endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }
}
