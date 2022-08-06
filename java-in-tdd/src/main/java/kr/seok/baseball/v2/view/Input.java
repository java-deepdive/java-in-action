package kr.seok.baseball.v2.view;

import kr.seok.baseball.v2.balls.Balls;

public class Input {
	
	public void printStart() {
		System.out.println("게임 시작");
	}
	
	public boolean isRetry() {
		System.out.println("재시작 확인");
		return false;
	}
	
	public Balls playerTurn() {
		System.out.println("플레이어 턴");
		return null;
	}
}
