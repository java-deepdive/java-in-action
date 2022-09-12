package kr.seok.baseball.v4;

public class BaseBall {
	
	/**
	 * 1. 컴퓨터가 랜덤으로 3개의 숫자를 생성한다.
	 * 2. 사용자가 3개의 숫자를 입력한다.
	 * 3. 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교한다.
	 * 4. 비교의 기준은 숫자의 크기, 위치를 비교하여 스트라이크와 볼로 구분한다.
	 * 5. 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자가 같으면 게임이 종료된다.
	 */
	public void play() {
		// 1. 컴퓨터가 랜덤으로 3개의 숫자를 생성한다.
		Computer computer = new Computer();
		computer.generate();
		
		// 2. 사용자가 3개의 숫자를 입력한다.
		User user = new User();
		String input = user.input();
		
		// 3. 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교한다.
		// 4. 비교의 기준은 숫자의 크기, 위치를 비교하여 스트라이크와 볼로 구분한다.
		// 5. 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자가 같으면 게임이 종료된다.
		while (!computer.isSame(input)) {
			computer.compare(user);
			user.input();
		}
	}
	
}
