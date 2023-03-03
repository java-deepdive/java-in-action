package kr.seok.java8.time;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LocalDateTimePracticeTest {
	
	@DisplayName("자바에서 ISO_LOCAL_DATE_TIME 포맷으로 날짜 생성 테스트")
	@Test
	void testCase1() {
		String format = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		String substring = format.substring(0, 19);
		System.out.println("format = " + substring);
		assertThat(substring).hasSize(19);
	}
}