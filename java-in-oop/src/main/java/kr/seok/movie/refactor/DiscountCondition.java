package kr.seok.movie.refactor;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 문제점 1: 새로운 할인 조건 추가시 로직 수정해야하는 문제
 * 문제점 2: 순번 조건을 판단하는 로직
 * 문제점 3: 기간 조건을 판단하는 로직이 변경되는 경우 기간 관련 필드의 타입 또는 추가가 필요하게 됨
 *
 * 해결책 > 타입의 분리
 */
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
