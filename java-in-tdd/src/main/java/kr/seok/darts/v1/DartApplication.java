package kr.seok.darts.v1;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DartApplication {
	
	private final Scanner in = new Scanner(System.in);
	
	public DartApplication() {
		
		int maxScore = parseInt(maxScoreSetting());
		int participantCnt = parseInt(participantCntSetting());
		
		new DartGame().play(in, maxScore, participantCnt);
	}
	
	public static void main(String[] args) {
		new DartApplication();
	}
	
	private String maxScoreSetting() {
		// 1. 사용자에게 최대 값 입력 받기
		return in.nextLine();
	}
	
	private String participantCntSetting() {
		return in.nextLine();
	}
	
}
