package kr.seok.baseball.v3.component;

import java.util.Scanner;

public class Input {
	private final Scanner scanner;
	
	public Input() {
		scanner = new Scanner(System.in);
	}
	
	public String numbers() {
		return scanner.nextLine();
	}
	
	public boolean isReGame() { // 입력 받아서 메뉴로 관리할 수 있는 방법 생각
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return scanner.nextLine().equals("2");
	}
}
