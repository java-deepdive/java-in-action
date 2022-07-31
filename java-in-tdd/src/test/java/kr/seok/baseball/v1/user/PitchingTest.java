package kr.seok.baseball.v1.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PitchingTest {
	
	@Test
	void testCase1() {
		Balls com = new Balls(1, 2, 3);
		Balls player = new Balls(3, 1, 2);
		
		Pitching pitching = new Pitching(com, player);
		pitching.report();
	}
}