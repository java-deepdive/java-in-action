package kr.seok.java8.chicken.v8;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;

import java.util.List;

public class ChickenReduce {
	
	private ChickenReduce() {}
	
	// 특정 브랜드의 치킨 가격의 총합을 반복문을 통해 구하는 메서드
	public static int sumPriceByBrand(List<Chicken> chickens, ChickenBrand brand) {
		int sum = 0;
		for (Chicken chicken : chickens) {
			if (chicken.isMatchBrand(brand)) {
				sum += chicken.getPrice();
			}
		}
		return sum;
	}
	
	// 특정 브랜드의 치킨 가격의 총합을 stream 사용해서 구하는 메서드
	public static int sumPriceByBrandStream(List<Chicken> chickens, ChickenBrand brand) {
		return chickens.stream()
				.filter(chicken -> chicken.isMatchBrand(brand))
				.mapToInt(Chicken::getPrice)
				.sum();
	}
	
	// 특정 브랜드의 치킨 가격의 총합을 reduce를 통해 구하는 메서드
	public static int getTotalPriceByBrand(List<Chicken> chickens, ChickenBrand brand) {
		return chickens.stream()
				.filter(chicken -> chicken.isMatchBrand(brand))
				.map(Chicken::getPrice)
				.reduce(0, Integer::sum);
				
	}
}
