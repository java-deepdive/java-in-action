package kr.seok.chapter11.biling.step05;

import kr.seok.chapter10.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneTest {

    @DisplayName("통화 기록에 따른 요금 부하 테스트")
    @Test
    void testCase1() {
        Phone phone = new Phone(
                new RegularPolicy( // 고정요금 방식: 10초당 18원
                        Money.wons(18),
                        Duration.ofSeconds(10)
                )
        );

        // 10분 * 60 = 600 초
        // 600 초 / 10 * 18원 = 1080원
        phone.call(new Call(
                LocalDateTime.of(2021, 6, 12, 18, 0, 0),
                LocalDateTime.of(2021, 6, 12, 18, 10, 0)
                ));

        Money actual = phone.calculateFee();
        assertThat(actual).hasToString("1080.0");
    }
}
