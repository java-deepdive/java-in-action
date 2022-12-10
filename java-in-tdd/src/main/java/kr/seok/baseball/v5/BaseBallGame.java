package kr.seok.baseball.v5;

import static kr.seok.baseball.v5.Output.Message.GAME_START;
import static kr.seok.baseball.v5.Output.Message.ROUND_START;

public class BaseBallGame {
	private final Input input;
	private final Output output;
	
	public BaseBallGame(Input input, Output output) {
		this.input = input;
		this.output = output;
	}
	
	public void run(NumberGenerator numberGenerator) {
		output.print(GAME_START.getMessage());
		do { // 게임의 시작과 끝을 결정하는 반복문
			
			output.print(ROUND_START.getMessage());
			// 컴퓨터 숫자 생성
			int[] randomNumbers = numberGenerator.generate();
			
			round(randomNumbers, numberGenerator);// 게임 시작 (랜덤한 숫자 3개 생성하여 게임 시작)
			
		} while (!input.isReGame());
	}
	
	private void round(int[] randomNumbers, NumberGenerator numberGenerator) {
		// 컴퓨터가 생성한 숫자 3개를 주입받아 라운드 시작
		int[] user;
		do {
			// 사용자 입력
			user = input.userNumbers(numberGenerator);
			
		} while (compareTo(randomNumbers, user)); // 컴퓨터와 사용자의 숫자 비교
		output.print("3스트라이크로 라운드를 종료합니다.");
	}
	
	private boolean compareTo(int[] computer, int[] user) {
		// 컴퓨터와 사용자의 숫자 비교
		return false;
	}
}
