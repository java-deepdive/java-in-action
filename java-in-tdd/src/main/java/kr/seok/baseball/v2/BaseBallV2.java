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
			
			ComBall com = new ComBall(MIN.value(), MAX.value());
			System.out.println("com = " + com);
			startGame(com);
			
		} while (!isReGame());
	}
	
	private void startGame(ComBall com) {
		System.out.println("게임스타트");
		PitchReport report;
		do {
			List<Ball> user = inputUser();
			report = round(com, user);
			
			System.out.println("report = " + report);
		} while (!report.threeStrike());
		System.out.println("종료");
	}
	
	private List<Ball> inputUser() {
		String[] split = in.nextLine().split("");
		return Arrays.stream(split)
			.map(Ball::new)
			.collect(Collectors.toList());
	}
	
	public PitchReport round(ComBall com, List<Ball> user) {
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

	private boolean isReGame() {
		System.out.println("재시작 여부 ex) exit");
		String nextLine = in.nextLine();
		return "exit".equals(nextLine);
	}
}
