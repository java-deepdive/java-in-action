package kr.seok.baseball.v3.component;

import kr.seok.baseball.v3.BallMapper;
import kr.seok.baseball.v3.vo.Balls;
import kr.seok.baseball.v3.vo.PitchReport;

import static kr.seok.baseball.v3.common.Logging.info;
import static kr.seok.baseball.v3.common.Logging.printReport;

public class Round {
	
	public static final String MESSAGES_INPUT_NUMBER = "숫자를 입력해주세요 : ";
	public static final String MESSAGES_END_ROUND = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	
	public void round(Input input) { // 한 번의 라운드를 처리하는 메서드
		
		Balls com = Balls.generateRandomBalls();
		info("컴퓨터가 생성한 숫자 : " + com);
		PitchReport report;
		do {
			
			info(MESSAGES_INPUT_NUMBER);
			Balls user = BallMapper.from(input.numbers());
			// 컴퓨터 숫자와 사용자 숫자를 비교하여 파악한 결과를 저장
			report = Pitch.report(com, user);
			
			printReport(report);
			
		} while (!report.isStrike());
		
		info(MESSAGES_END_ROUND);
	}
}
