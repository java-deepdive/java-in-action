package kr.seok.baseball.v4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class ComputerTest {
	
	@DisplayName("컴퓨터가 랜덤으로 3개의 숫자를 생성한다.")
	@Test
	void testCase1() {
		Random random = new Random();
		int nextInt = random.nextInt(10);
		assertThat(nextInt).isBetween(0, 9);
	}
	
	@DisplayName("컴퓨터가 서로 다른 숫자 3개를 생성했는지 확인하는 테스트")
	@Test
	void testCase2() {
		// given
		Computer computer = new Computer();
		// when
		computer.generate();
		int[] numbers = computer.getNumbers();
		// then
		assertAll(
			() -> assertThat(numbers).hasSize(3),
			() -> assertThat(numbers[0]).isNotEqualTo(numbers[1]),
			() -> assertThat(numbers[0]).isNotEqualTo(numbers[2]),
			() -> assertThat(numbers[1]).isNotEqualTo(numbers[2])
		);
	}
	
	@DisplayName("사용자가 입력한 값이 숫자가 아닌 경우 예외를 발생시킨다.")
	@ValueSource(strings = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,',<,>,?,/,.,")
	@ParameterizedTest(name = "{index} => 사용자 입력 값 = {0}")
	void testCase3(String param) {
		// given
		Computer computer = new Computer();
		// then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> computer.isSame(param))
			.withMessage("사용자가 입력한 값이 숫자가 아닙니다.");
	}
}