package kr.seok.movie.refactor;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isSatisfiedBy(Screening screening) {
        if(type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }
        return isSatisfiedBySequence(screening);
    }

    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return this.dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek())
                && this.startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0
                && this.endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }
}
