package kr.seok.baseball.v1.game;

import kr.seok.baseball.v1.user.Computer;
import kr.seok.baseball.v1.user.Player;
import kr.seok.baseball.v1.view.Input;
import kr.seok.baseball.v1.view.Output;


public class BaseBall implements Runnable {
	
	private Input input;
	private Output output;
	
	public BaseBall(Input input, Output output) {
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
		input.printStart();
		Computer computer = new Computer();
		Player player = new Player();
		game(computer, player);
	}
	
	private void game(Computer computer, Player player) {
		computer.turn();
		player.turn();
	}
}
