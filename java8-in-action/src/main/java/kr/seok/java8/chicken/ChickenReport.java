package kr.seok.java8.chicken;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ChickenReport {
	private final List<Chicken> chickens;
	
	public ChickenReport(List<Chicken> chickens) {
		this.chickens = chickens;
	}
	
	public List<Chicken> getChickens() {
		return this.chickens;
	}
	
	public Map<ChickenBrand, List<Chicken>> singleSizeReport() {
		return this.chickens.stream()
			.filter(ChickenReport::isSinglePrice)
			.collect(groupingBy(Chicken::getBrand));
	}
	
	private static boolean isSinglePrice(Chicken chicken) {
		return chicken.getPrice() <= 12_000;
	}
}
