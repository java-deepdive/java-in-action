package kr.seok.java8.chicken.v7;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ChickenOptionalTest {
	
	@DisplayName("특정 고객정보의 조회 실패 테스트")
	@Test
	void testCase1() {
		ChickenOptional chickenOptional = new ChickenOptional();
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> chickenOptional.getOrderChicken(null))
			.withMessage("사용자 정보를 조회할 수 없습니다.");
	}
	
	@DisplayName("특정 주문정보의 조회 실패 테스트")
	@Test
	void testCase2() {
		ChickenOptional chickenOptional = new ChickenOptional();
		User user = new User("SR");
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> chickenOptional.getOrderChicken(user))
			.withMessage("주문 정보를 조회할 수 없습니다.");
	}
	
	@DisplayName("특정 치킨정보의 조회 실패 테스트")
	@Test
	void testCase3() {
		ChickenOptional chickenOptional = new ChickenOptional();
		User user = new User("SR");
		user.order(new Order());
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> chickenOptional.getOrderChicken(user))
			.withMessage("치킨 정보를 조회할 수 없습니다.");
	}
	
	@DisplayName("특정 치킨정보의 조회 성공 테스트")
	@Test
	void testCase4() {
		ChickenOptional chickenOptional = new ChickenOptional();
		
		Order order = new Order();
		order.setChicken(new Chicken(ChickenBrand.BBQ, 10000));
		User user = new User("SR");
		user.order(order);
		
		String orderChicken = chickenOptional.getOrderChicken(user);
		assertThat(orderChicken).isEqualTo("BBQ");
	}
}