package kr.seok.baseball.v1.game;

import kr.seok.baseball.v1.balls.Balls;
import kr.seok.baseball.v1.user.Computer;
import kr.seok.baseball.v1.balls.Pitching;
import kr.seok.baseball.v1.view.Input;
import kr.seok.baseball.v1.view.Output;


public class BaseBallGame implements Runnable {
	
	private final Input input;
	private final Output output;
	
	public BaseBallGame(Input input, Output output) {
		this.input = input;
		this.output = output;
	}
	
	/**
	 * 1. 컴퓨터 턴
	 * 2. 사용자 턴
	 * 3. 게임 재시작
	 */
	@Override
	public void run() {
		input.printStart(); // 게임 시작 문구
		Balls comBalls;
		Balls playerBalls;
		Pitching pitching;
		do {
			// 1. 컴퓨터 턴
			// 2. 사용자 입력
			// 3. 투구 매칭
			// 4. 재시작 여부
			
			comBalls = Computer.turn();
			playerBalls = input.playerTurn();
			pitching = new Pitching(comBalls, playerBalls);
			
		} while (matchers(comBalls, playerBalls) || input.isRetry()); // 게임 재시작
		
		output.report(pitching); // 게임 종료 및 결과
	}
	
	private boolean matchers(Balls comBalls, Balls playerBalls) {
		return false;
	}
	
	public static class Builder {
		private Input input;
		private Output output;
		
		public Builder input(Input input) {
			this.input = input;
			return this;
		}
		
		public Builder output(Output output) {
			this.output = output;
			return this;
		}
		public BaseBallGame build() {
			return new BaseBallGame(input, output);
		}
	}
}
