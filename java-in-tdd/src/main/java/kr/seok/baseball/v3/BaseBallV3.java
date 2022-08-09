package kr.seok.baseball.v3;

import kr.seok.baseball.v3.component.Input;
import kr.seok.baseball.v3.component.Logging;
import kr.seok.baseball.v3.component.Pitch;
import kr.seok.baseball.v3.vo.Balls;
import kr.seok.baseball.v3.vo.PitchReport;

public class BaseBallV3 {
	
	public void run() {
		Input input = new Input();
		Logging log = new Logging();
		
		log.info("프로그램 시작");
		do { // 게임의 시작과 끝을 결정하는 반복문
			
			log.info("게임 시작");
			
			round(input, log); // 게임 시작 (랜덤한 숫자 3개 생성하여 게임 시작)
			
		} while (!input.isReGame());
	}
	
	private void round(Input input, Logging log) { // 한 번의 라운드를 처리하는 메서드
		
		log.info("컴퓨터의 숫자 3개를 생성합니다.");
		Balls com = Balls.generateRandomBalls();
		PitchReport report;
		do {
			
			log.info("사용자의 숫자 3개를 입력하세요.");
			Balls user = Converter.from(input.userTurn());
			// 컴퓨터 숫자와 사용자 숫자를 비교하여 파악한 결과를 저장
			log.info("컴퓨터의 숫자와 사용자의 숫자를 비교합니다.");
			report = Pitch.report(com, user);
			
			log.printReport(report);
			
		} while (report.isStrike());
		
		
	}
}
