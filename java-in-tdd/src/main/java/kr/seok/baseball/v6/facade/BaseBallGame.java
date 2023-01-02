package kr.seok.baseball.v6.facade;

import kr.seok.baseball.v6.io.Input;
import kr.seok.baseball.v6.io.Output;
import kr.seok.baseball.v6.numbers.Balls;
import kr.seok.baseball.v6.numbers.Pitching;
import kr.seok.baseball.v6.strategy.NumberGenerator;

/**
 * 숫자 야구 게임을 실행하는 클래스
 */
public class BaseBallGame {
	private final Input input;
	private final Output output;
	
	public BaseBallGame(Input input, Output output) {
		this.input = input;
		this.output = output;
	}
	
	public void run(int numberSize, NumberGenerator numberGenerator) {
		// 게임이라는 로직의 트랜잭션
		do {
			// 컴퓨터 숫자 생성
			Balls targetNumber = numberGenerator.hits(numberSize);
			// 라운드 시작 및 종료
			Pitching pitchingResult = new Round(input, output, targetNumber)
				.start(numberSize);
			
			output.print(pitchingResult.toString());
			
		} while(input.isReGame());
	}
}
