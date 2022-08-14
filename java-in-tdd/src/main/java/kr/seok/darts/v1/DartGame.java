package kr.seok.darts.v1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DartGame {
	
	public void play(Scanner in, int maxScore, int participantCnt) {

		List<User> users = participants(participantCnt);
		
		int turn = 0;
		do {
			turn++;
			
			for(User user : users) {
				int userScore = parseInt(user.turn(in));
				user.plusScore(userScore);
			}
			
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
