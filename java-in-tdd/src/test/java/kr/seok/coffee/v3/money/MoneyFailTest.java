package kr.seok.coffee.v3.money;

import kr.seok.coffee.v3.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyFailTest {
	
	@DisplayName("금액 차감 테스트")
	@Test
	void testCase1() {
		// given
		Money money = Money.wons(10000);
		// when
		Money result = money.minus(Money.wons(1000));
		// then
		assertThat(Money.wons(9000)).isEqualTo(result);
	}
	
	@DisplayName("금액 차감 반복문 테스트")
	@Test
	void testCase2() {
		// given
		Money money = Money.wons(10000);
		// when
		for (int i = 0; i < 10; i++) {
			money = money.minus(Money.wons(1000));
		}
		// then
		assertThat(Money.wons(0)).isEqualTo(money);
	}
	
	@DisplayName("금액 차감(long) 반복문 테스트")
	@Test
	void testCase3() {
		// given
		Money money = Money.wons(10000);
		// when
		for (int i = 0; i < 10; i++) {
			money = money.minus(1000);
		}
		// then
		assertThat(Money.wons(0)).isEqualTo(money);
	}
	
	@DisplayName("금액 차감 Thread 테스트")
	@Test
	void testCase4() throws InterruptedException {
		// given
		final Money[] money = {Money.wons(10000)};
		int nThreads = 100;
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		CountDownLatch countDownLatch = new CountDownLatch(10);
		// when
		for (int i = 0; i < nThreads; i++) {
			executorService.execute(() -> {
				money[0] = money[0].minus(Money.wons(100));
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		// then
		assertThat(money[0]).isEqualTo(Money.ZERO);
	}
	
	@DisplayName("금액 차감(long) Thread 테스트")
	@Test
	void testCase5() {
		// given
		final Money[] money = {Money.wons(10000)};
		int nThreads = 100;
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		CountDownLatch countDownLatch = new CountDownLatch(10);
		// when
		for (int i = 0; i < nThreads; i++) {
			executorService.execute(() -> {
				money[0] = money[0].minus(100);
				countDownLatch.countDown();
			});
		}
		// then
		assertThat(money[0]).isEqualTo(Money.ZERO);
	}
}