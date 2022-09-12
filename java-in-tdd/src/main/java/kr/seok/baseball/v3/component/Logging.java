package kr.seok.baseball.v3.component;

import kr.seok.baseball.v3.vo.PitchReport;

public class Logging {
	
	public void info(String messages) {
		System.out.println(messages);
	}
	
	public void printf(String messages) {
		System.out.print(messages);
	}
	
	public void printReport(PitchReport report) {
		System.out.println(report.toString());
	}
}
