package kr.seok.darts;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DartGame {
	
	public void play(Scanner in, int maxScore, int participantCnt) {
		// 1. 최대 점수 값 설정
		// 2. 게임에 참여할 인원 추가
		// 3. 사용자의 다트 투척 및 점수 확인
		// 4. 3차례 투척 후 점수와 최대 점수를 비교
		
		List<User> users = participants(participantCnt);
		
		int turn = 0;
		do {
			turn++;
			
			// 2.1 참여한 사용자의 숫자 만큼 투척 시도
			
			for(User user : users) {
				// 2.2 사용자에게 입력 받기
				int userScore = parseInt(user.turn(in));
				user.plusScore(userScore);
			}
			
			// 2.2 최대 점수와 사용자 입력 점수 확인
			
			// 2.3 사용자의 점수와 최대 점수가 같으면 종료
			
		} while (turn != 3);
		
		for(User user : users) {
			if(user.score > maxScore) {
				System.out.println("최대 점수를 초과하였습니다.");
			}
		}
	}
	
	private List<User> participants(int participantCnt) {
		List<User> users = new ArrayList<>();
		for(int i = 0; i < participantCnt; i++) {
			User user = new User(0, i);
			users.add(user);
		}
		return users;
	}
	
	class User {
		int score;
		final int userId;
		
		public User(int score, int userId) {
			this.score = score;
			this.userId = userId;
		}
		
		public int plusScore(int score) {
			return this.score += score;
		}
		
		public String turn(Scanner in) {
			return in.nextLine();
		}
	}
}
