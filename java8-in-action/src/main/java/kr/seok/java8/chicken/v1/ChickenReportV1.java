package kr.seok.java8.chicken.v1;

import kr.seok.java8.chicken.Chicken;
import kr.seok.java8.chicken.ChickenBrand;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ChickenReportV1 {
	private final List<Chicken> chickens;
	
	public ChickenReportV1(List<Chicken> chickens) {
		this.chickens = chickens;
	}
	
	public List<Chicken> getChickens() {
		return this.chickens;
	}
	
	public Map<ChickenBrand, List<Chicken>> singleSizeReport() {
		return this.chickens.stream()
			.filter(ChickenReportV1::isSinglePrice)
			.collect(groupingBy(Chicken::getBrand));
	}
	
	private static boolean isSinglePrice(Chicken chicken) {
		return chicken.getPrice() <= 12_000;
	}
}
