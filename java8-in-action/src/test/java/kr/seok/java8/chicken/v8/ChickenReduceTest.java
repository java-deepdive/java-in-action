package kr.seok.java8.chicken.v8;

import kr.seok.java8.chicken.ChickenBrand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Repeatable;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ChickenReduceTest {
	
	@DisplayName("특정 브랜드의 치킨 가격의 총합을 반복문을 통해 구하는 테스트")
	@Test
	void testCase1() {
		int sumPriceByBrand = ChickenReduce.sumPriceByBrand(ChickenFixture.getChickenFixture(), ChickenBrand.NENE);
		
		assertThat(sumPriceByBrand).isEqualTo(ChickenFixture.getNeneChickenPrice());
	}
	
	@DisplayName("mapToInt vs reduce 성능 측정 테스트")
	@Test
	void testCase5() {
		long start = System.currentTimeMillis();
		int sumPriceByBrand = ChickenReduce.sumPriceByBrand(ChickenFixture.getChickenFixture(), ChickenBrand.NENE);
		long end = System.currentTimeMillis();
		System.out.println("for-each => sumPriceByBrand : " + (end - start));
		
		start = System.currentTimeMillis();
		int sumPriceByBrandStream = ChickenReduce.sumPriceByBrandStream(ChickenFixture.getChickenFixture(), ChickenBrand.NENE);
		end = System.currentTimeMillis();
		System.out.println("Stream mapToInt => sumPriceByBrandStream : " + (end - start));
		
		start = System.currentTimeMillis();
		int totalPriceByBrand = ChickenReduce.getTotalPriceByBrand(ChickenFixture.getChickenFixture(), ChickenBrand.NENE);
		end = System.currentTimeMillis();
		System.out.println("Stream reduce => totalPriceByBrand : " + (end - start));
		
		assertAll(
				() -> assertThat(sumPriceByBrand).isEqualTo(ChickenFixture.getNeneChickenPrice()),
				() -> assertThat(sumPriceByBrandStream).isEqualTo(ChickenFixture.getNeneChickenPrice()),
				() -> assertThat(totalPriceByBrand).isEqualTo(ChickenFixture.getNeneChickenPrice())
		);
	}
	
	@DisplayName("int 타입의 mapToInt vs reduce 성능 측정 테스트")
	@Test
	@RepeatedTest(100)
	void testCase6() {
		Map<String, Integer> dummyMap = new HashMap<>();
		
		for(int i = 0; i < 1000000; i++) {
			dummyMap.put("" + i, i);
		}
		long start = System.currentTimeMillis();
		int sum = 0;
		for (Integer value : dummyMap.values()) {
			sum += value;
		}
		long end = System.currentTimeMillis();
		System.out.println("for-each => sum : " + (end - start));
		
		start = System.currentTimeMillis();
		int sum2 = dummyMap.values().stream().parallel().mapToInt(Integer::intValue).sum();
		end = System.currentTimeMillis();
		
		System.out.println("Stream => mapToInt : " + (end - start));
		
		start = System.currentTimeMillis();
		int sum3 = dummyMap.values().stream().parallel().reduce(0, Integer::sum);
		end = System.currentTimeMillis();
		
		System.out.println("Stream => reduce : " + (end - start));
	}
}