package kr.seok.baseball.v6.facade;

import kr.seok.baseball.v6.io.Input;
import kr.seok.baseball.v6.io.Output;
import kr.seok.baseball.v6.numbers.Numbers;
import kr.seok.baseball.v6.numbers.Pitching;

/**
 * 한 차례 게임을 진행하는 클래스
 */
public class Round {
	
	private final Input input;
	private final Output output;
	private final Numbers targetNumber;
	
	public Round(Input input, Output output, Numbers targetNumber) {
		this.input = input;
		this.output = output;
		this.targetNumber = targetNumber;
	}
	
	public Pitching start(int numberSize) {
		// 라운드의 트랜잭션
		// 1. 사용자의 투구
		// 2. 사용자의 투구와 컴퓨터의 투구를 비교
		// 3. 결과 출력
		// 4. 3S가 나올때까지 반복
		// 5. 3S가 나오면 라운드 종료
		Pitching pitching;
		do {
			
			Numbers userNumber = input.numbers(numberSize);
			
			pitching = new Pitching(targetNumber)
				.matches(userNumber);
			
			output.print(pitching.toString());
			
		} while(pitching.isStrike());
		
		return pitching;
	}
}
