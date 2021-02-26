package kr.seok.java8.chap5;

import kr.seok.java8.chap4.Dish;

import java.util.Optional;

import static kr.seok.java8.chap4.Dish.menu;

/**
 * 검색과 매칭
 *  - 특정 속성이 데이터 집합에 있는지 여부를 검색
 *
 *  findAny(), findFirst() 같은 메서드가 필요한 이유는 병렬 처리하려는 경우
 *  병렬 실행 시 첫 번째 요소를 찾기 힘듬, 요소의 반환 순서가 상관 없다면 병렬 스트림에서 제약이 적은 findAny를 사용한다.
 *
 */
public class Finding {

    public static void main(String... args) {
        if (isVegetarianFriendlyMenu()) {
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());

        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }

    private static boolean isVegetarianFriendlyMenu() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }

}
