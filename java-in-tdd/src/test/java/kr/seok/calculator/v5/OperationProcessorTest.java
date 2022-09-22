package kr.seok.calculator.v5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class OperationProcessorTest {
	
	@DisplayName("enum elapsed time StopWatch Check")
	@Test
	void testCase1() {
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start("Map 사용");
		for (int i = 0; i < 1000000; i++) {
			OperationProcessor.of("+");
		}
		stopWatch.stop();
		
		stopWatch.start("Arrays.stream 사용");
		for (int i = 0; i < 1000000; i++) {
			kr.seok.calculator.v3.OperationProcessor.of("+");
		}
		stopWatch.stop();
		
		System.out.println(stopWatch.shortSummary());
		System.out.println(stopWatch.prettyPrint());
		System.out.println(stopWatch.getTotalTimeMillis());
	}
	
	@Disabled
	@DisplayName("enum stress test")
	@Test
	void testCase2() throws InterruptedException {
		int threadCount = 10;
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		
		for (int i = 0; i < 10; i++) {
			executorService.execute(() -> {
				for (int j = 0; j < 10; j++) {
					OperationProcessor processor = OperationProcessor.of("+");
					System.out.println("processor = " + processor);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
	}
}