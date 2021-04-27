package kr.seok.java8.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamBasic {
    /*
        서술 방식의 코드 스타일 -> 외부 연산
     */
    public static List<String> getLowCaloricDishesNamesInJava7(final List<Dish> dishes) {
        final List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishes) {
            if (d.getCalories() > 400) { // 칼로리 400 초과 하는 메뉴
                lowCaloricDishes.add(d);
            }
        }
        final List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() { // 칼로리 높은 순으로 정렬
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for (Dish d : lowCaloricDishes) { // Dish -> getName 으로 추출
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    /*
        자바8 에서 제공하는 stream, 람다 표현식, 메서드 레퍼런스로 구현한 코드
        -> 내부 연산
     */
    public static List<String> getLowCaloricDishesNamesInJava8(final List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() > 400) // filter: 특정 조건에 따른 제외 연산
                .sorted(comparing(Dish::getCalories)) // sorted: 객체의 값을 비교하여 정렬 연산
                .map(Dish::getName) // 한 요소를 다른 요소로 변환하거나 정보를 추출하는 연산
                .collect(toList()); // 스트림을 리스트로 변환하는 단말 연산
    }
}
