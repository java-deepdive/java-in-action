package kr.seok.baseball.v3.component;

import kr.seok.baseball.v3.vo.PitchReport;

public class Logging {
	
	public void info(String messages) {
		System.out.println(messages);
	}
	
	public void printReport(PitchReport report) {
		System.out.println("스트라이크 : " + report.getStrike());
		System.out.println("볼 : " + report.getBall());
	}
}
