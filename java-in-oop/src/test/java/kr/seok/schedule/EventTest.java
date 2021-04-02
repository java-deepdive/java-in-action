package kr.seok.schedule;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

class EventTest {

    @Test
    void testCase1() {
        Event event = new Event(
                "회의",
                LocalDateTime.of(2019, 5, 8, 10, 30),
                Duration.ofMinutes(30)
        );

    }
}
