package kr.seok.movie.condition;

import kr.seok.movie.Screening;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;

import static java.time.chrono.ChronoLocalDateTime.from;

public class PeriodCondition implements DiscountCondition {
    private final DayOfWeek dayOfWeek;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalDateTime startTime, LocalDateTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek)
                && startTime.compareTo(getFrom(screening.getStartTime().toLocalTime())) <= 0
                && endTime.compareTo(getFrom(screening.getStartTime().toLocalTime())) >= 0;
    }

    private ChronoLocalDateTime<?> getFrom(LocalTime screening) {
        return from(screening);
    }
}
