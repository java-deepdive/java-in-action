package kr.seok.baseball.v3;

import kr.seok.baseball.v3.component.Input;
import kr.seok.baseball.v3.component.Round;
import kr.seok.baseball.v3.vo.Balls;

import static kr.seok.baseball.v3.common.Logging.info;

public class BaseBallV3 {
	
	public void run() {
		Input input = new Input();
		info("프로그램 시작");
		do { // 게임의 시작과 끝을 결정하는 반복문
			
			info("게임 시작");
			new Round().round(input); // 게임 시작 (랜덤한 숫자 3개 생성하여 게임 시작)
			
		} while (!input.isReGame());
	}
	
	
}
