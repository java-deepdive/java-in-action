package kr.seok.coffee.v1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeOrderV1 {
	private Scanner in = new Scanner(System.in);
	
	/**
	 * 1. 커피 메뉴를 출력
	 * 2. 사용자는 커피 메뉴 중 하나를 선택
	 * 3. 선택한 커피 메뉴를 바리스타에게 주문
	 * 4. 바리스타는 주문받은 커피를 준비한다.
	 * 5. 커피가 제조되면 사용자에게 알려준다.
	 */
	public void run() {
		// 커피 메뉴를 출력
		printMenu();
		// 사용자는 커피 메뉴 중 하나를 선택
		CoffeeType menu = selectMenu();
		// 선택한 커피 메뉴를 바리스타에게 주문
		Coffee order = order(menu);
		// 제작된 커피를 사용자에게 알려준다.
		printCoffee(order);
	}
	
	private void printCoffee(Coffee order) {
		System.out.println("order.menu = " + order.menu);
	}
	
	private Coffee order(CoffeeType menu) {
		System.out.println("주문한 커피 : " + menu);
		return makeCoffee(menu);
	}
	
	private Coffee makeCoffee(CoffeeType menu) {
		System.out.println("커피를 준비하는중...");
		return new Coffee(menu);
	}
	
	private CoffeeType selectMenu() {
		return CoffeeType.valueOf(in.nextLine());
	}
	
	private void printMenu() {
		Arrays.stream(CoffeeType.values())
			.forEach(System.out::println);
	}
	
	class Coffee {
		private CoffeeType menu;
		
		public Coffee(CoffeeType menu) {
			this.menu = menu;
		}
	}
	public enum CoffeeType {
		BLACK_COFFEE,
		CAPPUCCINO,
		ESPRESSO,
		LATTE,
		MILK_COFFEE,
		MOCHA,
		WHITE_COFFEE;
		
		public static CoffeeType fromString(String coffeeType) {
			return CoffeeType.valueOf(coffeeType.toUpperCase());
		}
	}
}
