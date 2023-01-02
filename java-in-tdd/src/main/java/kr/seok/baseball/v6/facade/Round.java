package kr.seok.baseball.v6.facade;

import kr.seok.baseball.v6.io.Input;
import kr.seok.baseball.v6.io.Output;
import kr.seok.baseball.v6.numbers.Balls;
import kr.seok.baseball.v6.numbers.Pitching;

/**
 * 한 차례 게임을 진행하는 클래스
 */
public class Round {
	
	private final Input input;
	private final Output output;
	
	public Round(Input input, Output output) {
		this.input = input;
		this.output = output;
	}
	
	public Pitching start(Balls targetBall, int ballSize) {
		// 라운드의 트랜잭션
		// 1. 사용자의 투구
		// 2. 사용자의 투구와 컴퓨터의 투구를 비교
		// 3. 결과 출력
		// 4. 3S가 나올때까지 반복
		// 5. 3S가 나오면 라운드 종료
		Pitching pitching;
		do {
			
			Balls userBall = input.numbers(ballSize);
			
			pitching = Pitching.matches(targetBall, userBall);
			
			output.print(pitching.toString());
			
		} while(!pitching.isStrike());
		
		return pitching;
	}
}
