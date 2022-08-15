package kr.seok.coffee.v1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeOrderV1Test {
	
	@Test
	void testCase1() {
		CoffeeOrderV1.CoffeeType black_coffee = CoffeeOrderV1.CoffeeType.fromString("BLACK_COFFEE");
		assertThat(black_coffee).isEqualTo(CoffeeOrderV1.CoffeeType.BLACK_COFFEE);
	}
}