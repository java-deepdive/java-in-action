package kr.seok.coffee.v3;

import java.util.Scanner;

public class CoffeeOrderApplication {
	
	private final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		CoffeeOrderApplication coffeeOrderApplication = new CoffeeOrderApplication();
		coffeeOrderApplication.run();
	}
	
	/**
	 * 1. 역할을 선택
	 * 2. 손님 선택 시 커피 주문 (커피 이름, 가격)
	 * 3. 주문 내역 출력 (메뉴, 가격)
	 * 4. 쿠폰 적립 여부
	 * 5. 쿠폰 선택 시 전화번호 입력하여 보유하고 있는 쿠폰 정보 조회
	 * 6. 커피 주문 내역에 쿠폰 적용
	 * 7. 주문 결과 조회
	 */
	private void run() {
		CoffeeShop coffeeShop = new CoffeeShop();
		while (true) {
			System.out.println("1. 주문하기");
			System.out.println("2. 쿠폰 조회");
			System.out.println("3. 주문 내역 조회");
			System.out.println("4. 종료");
			System.out.println("원하는 기능을 선택해주세요.");
			int menu = scanner.nextInt();
			/*
				주문 시, 쿠폰 사용여부 -> 쿠폰 적용 후 주문 내역 출력
			 */
			if (menu == 1) {
				System.out.println("주문하실 커피의 이름과 가격을 입력해주세요.");
				String name = scanner.next();
				int price = scanner.nextInt();
				coffeeShop.order(name, price);
				
				System.out.println("쿠폰을 사용하시겠습니까?");
				System.out.println("1. 사용");
				System.out.println("2. 사용 안함");
				int coupon = scanner.nextInt();
				if (coupon == 1) {
					System.out.println("전화번호를 입력해주세요.");
					String phoneNumber = scanner.next();
					coffeeShop.findCoupon(phoneNumber);
					
				} else {
					System.out.println("주문 내역을 출력합니다.");
					coffeeShop.printOrder();
				}
			}
			if (menu == 2) {
				System.out.println("쿠폰을 조회하실 전화번호를 입력해주세요.");
				String phoneNumber = scanner.next();
				coffeeShop.findCoupon(phoneNumber);
			}
			if (menu == 3) {
				coffeeShop.printOrder();
			}
			if (menu == 4) {
				break;
			}
		}
	}
}
