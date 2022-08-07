package kr.seok.baseball.v1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseBallGame {
	
	private final Scanner in = new Scanner(System.in);
	
	public void run() {
		System.out.println("게임 시작");
		
		// 랜덤한 숫자 3개 생성
		System.out.println("컴퓨터 숫자 생성");
		List<Integer> com = com();
		
		while(true) {
			
			System.out.println("사용자 숫자 입력");
			String[] user = validUserInput();
			
			printReport(com, user);
			
			if(isReGame()) {
				break;
			}
		}
		
	}
	
	private void printReport(List<Integer> com, String[] user) {
		if(isMatches(com, user) == 3) {
			System.out.println("3 스트라이크 -> 게임 종료");
		} else if(isMatches(com, user) != 3) {
			System.out.println("user = " + user);
		}
	}
	
	private String[] validUserInput() {
		String[] user = in.nextLine().split("");// 입력 방식 123
		
		if(user.length != 3) {
			throw new RuntimeException("수가 부족");
		}
		
		for (String s : user) {
			int num = Integer.parseInt(s);
			if (num <= 0 || num > 9) {
				throw new RuntimeException("범위 내에 값이 아닙니다.");
			}
		}
		return user;
	}
	
	private boolean isReGame() {
		String nextLine = in.nextLine();
		return "exit".equals(nextLine);
	}
	
	private int isMatches(List<Integer> com, String[] user) {
		
		
		return 0;
	}
	
	public List<Integer> com() {
		return IntStream.rangeClosed(1, 9)
			.boxed()
			.limit(3)
			.collect(Collectors.toList());
	}
}
