package kr.seok.movie.v2;

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
		return screening.getStartTime().getDayOfWeek().equals(dayOfWeek)
			&& startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0
			&& endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
	}
}
