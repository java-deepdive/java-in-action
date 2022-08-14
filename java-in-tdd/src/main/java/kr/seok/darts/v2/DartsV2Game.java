package kr.seok.darts.v2;


import java.util.ArrayList;
import java.util.List;

/**
 * 1. 최대 점수 값 입력 받기
 * 2. 게임에 참여할 인원 입력 받기
 * 3. 최대 반복할 라운드 입력 받기
 * 4. 사용자의 다트 투척 및 점수 확인
 * 5. 최대 반복할 라운드만큼 투척 후 점수와 최대 점수를 비교하여 게임 종료 여부 확인
 */
public class DartsV2Game {
	
	private final InputDarts input = new InputDarts();
	
	/**
	 * 게임 시작 전 필요한 값을 입력 받아서 게임 시작
	 * 최대 점수 값, 게임에 참여할 인원, 최대 라운드 값을 입력 받아서 게임 시작
	 */
	public void play() {
		int maxScore;
		int roundCnt;
		do {
			maxScore = input.maxScore();
			int participantCnt = input.participantCnt();
			roundCnt = input.roundCnt();
			
			round(maxScore, participantCnt, roundCnt);
			
		} while (isContinue(maxScore, roundCnt));
		
	}
	
	private void round(int maxScore, int participantCnt, int roundCnt) {
		List<Participant> participants = makeParticipants(participantCnt);
		
	}
	
	private List<Participant> makeParticipants(int participantCnt) {
		List<Participant> participants = new ArrayList<>();
		
		for(int i = 0; i < participantCnt; i++) {
			Participant participant = new Participant(0, i);
			participants.add(participant);
		}
		return participants;
	}
	
	private boolean isContinue(int maxScore, int roundCnt) {
		return roundCnt > 0;
	}
}
