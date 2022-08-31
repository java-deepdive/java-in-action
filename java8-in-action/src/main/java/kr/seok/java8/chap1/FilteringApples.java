package kr.seok.java8.chap1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 메서드 파라미터, 람다를 사용한 조건 처리
 * <p>
 * 반복되는 코드가 많은 문제가 있음
 * <p>
 * 필터링 -> 추출 -> 그룹화
 */
public class FilteringApples {
	
	// 일반 조건문으로 분기처리된 메서드
	public List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	// 일반 조건문으로 분기처리된 메서드
	public List<Apple> filterHeavyApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/**
	 * 동작 파라미터화 코드 전달 메서드
	 * <p>
	 * Predicate<?>: 인수로 값을 받아 true나 false를 반환하는 함수
	 * boolean을 Boolean으로 변환하는 과정이 없어 더 효율적
	 */
	public List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
