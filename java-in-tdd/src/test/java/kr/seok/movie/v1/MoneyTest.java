package kr.seok.movie.v1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
	
	@DisplayName("금액 차감 테스트")
	@Test
	void testCase1() {
		// given
		Money money = Money.wons(10000);
		// when
		money = money.minus(Money.wons(1000));
		// then
		assertThat(Money.wons(9000)).isEqualTo(money);
	}
	
	@DisplayName("금액 차감 반복 테스트")
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
	
	@DisplayName("금액 차감 동시성 테스트")
	@Test
	void testCase3() {
		// given
		final Money[] money = {Money.wons(10000)};
		
		int nThreads = 100;
		int currentThread = 10;
		ExecutorService executorService = newFixedThreadPool(nThreads);
		CountDownLatch countDownLatch = new CountDownLatch(currentThread);
		
		// when
		for (int i = 0; i < currentThread; i++) {
			executorService.execute(() -> {
				money[0] = money[0].minus(Money.wons(1000));
				countDownLatch.countDown();
			});
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// then
		assertThat(money[0]).isEqualTo(Money.ZERO);
	}
}