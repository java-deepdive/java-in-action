package kr.seok.baseball.v5;

public class Output {
	
	public void print(String messages) {
		System.out.println(messages);
	}
	
	enum Message {
		GAME_START("숫자 야구 게임 시작"),
		ROUND_START("라운드 시작 시작"),
		END("숫자 야구 게임 종료");
		
		private String message;
		
		Message(String message) {
			this.message = message;
		}
		
		public String getMessage() {
			return message;
		}
	}
}
