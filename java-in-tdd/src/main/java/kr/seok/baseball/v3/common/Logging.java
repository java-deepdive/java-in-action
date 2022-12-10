package kr.seok.baseball.v3.common;

import kr.seok.baseball.v3.vo.PitchReport;

public class Logging {
	private Logging() {
	}
	
	public static void info(String messages) {
		System.out.println(messages);
	}
	
	public static void printf(String messages) {
		System.out.print(messages);
	}
	
	public static void printReport(PitchReport report) {
		System.out.println(report.toString());
	}
}
