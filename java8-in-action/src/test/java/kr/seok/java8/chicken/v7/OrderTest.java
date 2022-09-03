package kr.seok.java8.chicken.v7;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
	
	@DisplayName("동일한 order 정보인지 확인하는 테스트")
	@Test
	void testCase1() {
		Order order = new Order();
		order.setChicken(new Chicken(ChickenBrand.BBQ, 10000));
		
		Order expected = new Order();
		expected.setChicken(new Chicken(ChickenBrand.BBQ, 10000));
		assertThat(order).isEqualTo(expected);
	}
}