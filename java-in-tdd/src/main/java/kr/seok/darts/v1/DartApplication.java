package kr.seok.darts.v1;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DartApplication {
	
	private final Scanner in = new Scanner(System.in);
	
	/**
	 * 1. 최대 점수 값 입력 받기
	 * 2. 게임에 참여할 인원 입력 받기
	 * 3. 최대 반복할 라운드 입력 받기
	 * 4. 사용자의 다트 투척 및 점수 확인
	 * 5. 최대 반복할 라운드만큼 투척 후 점수와 최대 점수를 비교하여 게임 종료 여부 확인
	 */
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
