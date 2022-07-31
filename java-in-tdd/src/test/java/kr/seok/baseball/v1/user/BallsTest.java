package kr.seok.baseball.v1.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BallsTest {
	
	@DisplayName("투구 횟수 성공 테스트")
	@Test
	void pitch_ball_success() {
		Balls balls = new Balls(1, 2, 3);
		assertThat(balls.size()).isEqualTo(3);
	}
	
	@DisplayName("투구 횟수 실패 테스트")
	@Test
	void pitch_ball_fail() {
		assertThatExceptionOfType(RuntimeException.class)
			.describedAs("투구는 총 3차례 던져야 합니다.")
			.isThrownBy(() -> new Balls(1, 2));
	}
	
	@Test
	void testCase1() {
		int[] com = new int[]{1, 2, 3};
		int[] player = new int[]{2, 3, 1};
		
		int strikeCnt = 0;
		int ballCnt = 0;
		for (int i = 0; i < com.length; i++) {
			// 컴퓨터가 생성한 숫자를 사용자가 선택한 값과 매핑하는 과정
			int comBall = com[i];
			int comPlayer = player[i];
			
			if (comBall == comPlayer) {
				strikeCnt++;
			} else {
				ballCnt++;
			}
		}
		assertThat(strikeCnt).isZero();
		assertThat(ballCnt).isEqualTo(3);
	}
	
	@Test
	void testCase2() {
		Balls com = new Balls(1, 2, 3);
		Balls player = new Balls(2, 3, 1);
		
		int strikeCnt = 0;
		int ballCnt = 0;
		for (int i = 0; i < com.size(); i++) {
			// 컴퓨터가 생성한 숫자를 사용자가 선택한 값과 매핑하는 과정
			if (com.isMatches(i, player.get(i))) {
				strikeCnt++;
			} else if (com.contains(player.get(i))) {
				ballCnt++;
			}
		}
		assertThat(strikeCnt).isZero();
		assertThat(ballCnt).isEqualTo(3);
	}
}