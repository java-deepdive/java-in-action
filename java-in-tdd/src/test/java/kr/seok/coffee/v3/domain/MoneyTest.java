package kr.seok.coffee.v3.domain;

import kr.seok.coffee.v3.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
	
	@DisplayName("금액 객체 equals 비교 테스트")
	@Test
	void testCase1() {
		Money money = Money.wons(1000);
		assertThat(money).isEqualTo(Money.wons(1000));
	}
	
	@DisplayName("금액 차감 동시성 테스트")
	@RepeatedTest(value = 20, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
	void testCase2() {
		final Money[] money = {Money.wons(10000)};
		int nThreads = 100;
		ExecutorService executorService = newFixedThreadPool(nThreads);
		int currentThread = 10;
		CountDownLatch countDownLatch = new CountDownLatch(currentThread);
		for (int i = 0; i < currentThread; i++) {
			executorService.execute(() -> {
				money[0] = money[0].minus(100);
				countDownLatch.countDown();
			});
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertThat(money[0]).isEqualTo(Money.wons(9000));
	}
	
	@DisplayName("금액 차감 반복문 테스트")
	@Test
	void testCase3() {
		// given
		Money money = Money.wons(10000);
		// when
		for (int i = 0; i < 10; i++) {
			money = money.minus(Money.wons(1000));
		}
		// then
		assertThat(Money.wons(0)).isEqualTo(money);
	}
}