package kr.seok.baseball.v2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static kr.seok.baseball.v2.Ball.BallRule.MAX;
import static kr.seok.baseball.v2.Ball.BallRule.MIN;

public class BaseBallV2 {
	
	private final Scanner in = new Scanner(System.in);
	
	public void run() {
		do {
			System.out.println("게임 시작");
			System.out.println("컴퓨터 숫자 생성");
			
			RandomBall com = new RandomBall(MIN.value(), MAX.value());
			System.out.println("com = " + com);
			startGame(com);
			
		} while (!isReGame());
	}
	
	private void startGame(RandomBall com) {
		System.out.println("게임스타트");
		PitchReport report;
		do {
			List<Ball> user = inputUser();
			report = round(com, user);
			
			System.out.println("report = " + report);
		} while (!report.isStrike());
		System.out.println("종료");
	}
	
	private List<Ball> inputUser() {
		String[] split = in.nextLine().split("");
		return Arrays.stream(split)
			.map(Ball::new)
			.collect(Collectors.toList());
	}
	
	public PitchReport round(RandomBall com, List<Ball> user) {
		List<Ball> value = com.value();
		int s = 0;
		int b = 0;
		for (int i = 0; i < value.size(); i++) {
			Ball ball = value.get(i);
			if (ball.isMatches(user.get(i))) {
				s++;
			} else if (com.contains(user.get(i))){
				b++;
			}
		}
		return new PitchReport.Builder(s, b).build();
	}

//	private int round(List<Integer> com, String[] user) { // 컴퓨터 & 사람 숫자 매핑
//		int strike = 0;
//		int ball = 0;
//		for (int i = 0; i < user.length; i++) {
//			int useNum = Integer.parseInt(user[i]);
//			if (useNum == com.get(i)) {
//				strike++;
//			} else {
//				if (com.contains(useNum)) {
//					ball++;
//				}
//			}
//		}
//		System.out.println(strike + " 스트라이크 : " + ball + " 볼");
//		return strike;
//	}

//	private String[] validUserInput() {
//		String[] user = in.nextLine().split("");// 입력 방식 123
//
//		if (user.length != 3) {
//			throw new RuntimeException("수가 부족");
//		}
//
//		for (String s : user) {
//			int num = Integer.parseInt(s);
//			if (num <= 0 || num > 9) {
//				throw new RuntimeException("범위 내에 값이 아닙니다.");
//			}
//		}
//		return user;
//	}
	
	private boolean isReGame() {
		System.out.println("재시작 여부 ex) exit");
		String nextLine = in.nextLine();
		return "exit".equals(nextLine);
	}

//	public List<Integer> com() {
//		List<Integer> collect = IntStream.rangeClosed(1, 9)
//			.boxed()
//			.collect(Collectors.toList());
//		Collections.shuffle(collect);
//		return collect.subList(0, 3);
//	}

//	private void startGame(List<Integer> com) {
//		System.out.println("com = " + com);
//		String[] user;
//		do {
//			System.out.println("사용자 숫자 입력");
//			user = validUserInput(); // 사용자 입력
//
//		} while (round(com, user) != 3); // 사용자 & 컴퓨터 숫자 매핑하여 strike 3인지 확인
//	}
}
