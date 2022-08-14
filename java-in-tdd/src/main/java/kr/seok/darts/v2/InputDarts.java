package kr.seok.darts.v2;

import java.util.Scanner;

public class InputDarts {
	
	public static final Scanner in = new Scanner(System.in);
	
	public int maxScore() {
		System.out.println("최대 점수를 입력하세요.");
		return Integer.parseInt(in.nextLine());
	}
	
	public int participantCnt() {
		System.out.println("게임에 참여할 인원을 입력하세요.");
		return Integer.parseInt(in.nextLine());
	}
	
	public int roundCnt() {
		System.out.println("최대 라운드를 입력하세요.");
		return Integer.parseInt(in.nextLine());
	}
}
