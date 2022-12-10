package kr.seok.baseball.v3.component;

import kr.seok.baseball.v3.Converter;
import kr.seok.baseball.v3.vo.Balls;
import kr.seok.baseball.v3.vo.PitchReport;

import static kr.seok.baseball.v3.common.Logging.info;
import static kr.seok.baseball.v3.common.Logging.printReport;

public class Round {
	
	public void round(Input input) { // 한 번의 라운드를 처리하는 메서드
		
		Balls com = Balls.generateRandomBalls();
		PitchReport report;
		do {
			
			info("숫자를 입력해주세요 : ");
			Balls user = Converter.from(input.userTurn());
			// 컴퓨터 숫자와 사용자 숫자를 비교하여 파악한 결과를 저장
			report = Pitch.report(com, user);
			
			printReport(report);
			
		} while (!report.isStrike());
		
		info("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
