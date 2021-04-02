package kr.seok.schedule;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class RecurringScheduleTest {

    @Test
    void testCase() {
        RecurringSchedule schedule = new RecurringSchedule(
                "회의",
                DayOfWeek.WEDNESDAY,
                LocalTime.of(10, 30),
                Duration.ofMinutes(30) // 30분 동안 회의
        );

        assertThat(schedule.getDuration()).isEqualTo(Duration.ofMinutes(30));
    }

    @Test
    void testCase2() {
        RecurringSchedule schedule = new RecurringSchedule(
                "회의",
                DayOfWeek.WEDNESDAY,
                LocalTime.of(10, 30),
                Duration.ofMinutes(30) // 30분 동안 회의
        );

        Event event = new Event(
                "회의",
                LocalDateTime.of(2019, 5, 9, 10, 30),
                Duration.ofMinutes(30)
        );
        assertThat(event.isSatisfied(schedule)).isFalse(); // FALSE 가 반환되어야 함
        assertThat(event.isSatisfied(schedule)).isTrue();// 반복해서 조회 하는 경우 True를 반환하는 문제
    }

    @Test
    void testCase4() {
        RecurringSchedule schedule = new RecurringSchedule(
                "회의",
                DayOfWeek.WEDNESDAY,
                LocalTime.of(10, 30),
                Duration.ofMinutes(30) // 30분 동안 회의
        );

        // 9일은 목요일이므로 False 반환
        Event event = new Event(
                "회의",
                LocalDateTime.of(2019, 5, 9, 10, 30),
                Duration.ofMinutes(30)
        );
        // 쿼리와 명령을 분리하여 스케줄 재등록 처리
        if(!event.isSatisfied(schedule)) {
            event.reschedule(schedule);
        }
        assertThat(event.isSatisfied(schedule)).isTrue(); // FALSE 가 반환되어야 함
    }
}
