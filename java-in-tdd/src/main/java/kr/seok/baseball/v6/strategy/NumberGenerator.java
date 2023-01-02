package kr.seok.baseball.v6.strategy;

import kr.seok.baseball.v6.numbers.Balls;

@FunctionalInterface
public interface NumberGenerator {
	Balls hits(int numberSize);
}
