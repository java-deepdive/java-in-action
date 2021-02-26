package kr.seok.java8.chap5;

import kr.seok.java8.chap4.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static kr.seok.java8.chap4.Dish.menu;

public class FilteringTest {

    @Test
    @DisplayName("프레디케이트로 필터링 테스트")
    void testCase1() {

        // Predicate (boolean 을 반환)
        Predicate<Dish> isVegetarian = Dish::isVegetarian;

        List<Dish> vegetarianMenu = menu.stream()
                // isVegetarian 와 일치하는 모든 요소를 포함하는 스트림을 반환
                .filter(isVegetarian)
                .collect(toList());

        /*
            french fries
            rice
            season fruit
            pizza
         */
        vegetarianMenu.forEach(System.out::println);
    }

    @Test
    @DisplayName("고유 요소 필터링 filter + distinct()")
    void testCase2() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        Predicate<Integer> integerPredicate = i -> i % 2 == 0;
        numbers.stream()
                // Predicate 짝수 값만 필터링
                .filter(integerPredicate)
                // 짝수 값만 필터링된 값과 중복을 필터링
                .distinct()
                .forEach(System.out::println);

    }

    @Test
    @DisplayName("스트림 축소 limit()")
    void testCase3() {
        Predicate<Dish> dishPredicate = d -> d.getCalories() > 300;

        menu.stream()
                // 칼로리 300 초과된 조건부 필터링
                .filter(dishPredicate)
                // 정렬된 스트림의 최대 n개의 요소를 반환
                .limit(3)
                .collect(toList())
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("요소 건너뛰기 skip()")
    void testCase4() {
        final Predicate<Dish> dishPredicate = d -> d.getCalories() > 300;

        /*
            chicken
            french fries
            rice
            pizza
            prawns
            salmon
         */
        menu.stream()
                // 칼로리 300 초과하는 조건에 일치하는 모든 요소를 포함하는 스트림을 반환
                .filter(dishPredicate)
                // 처음 n개 요소를 제외한 스트림을 반환
                .skip(2)
                .collect(toList())
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("필터링 퀴즈: 고기 요리 2개 필터링하기")
    void testCase5() {
        final Predicate<Dish> dishPredicate = d -> d.getType() == Dish.Type.MEAT;

        menu.stream()
                // 고기 타입의 조건에 일치하는 모든 요소를 포함하는 스트림을 반환
                .filter(dishPredicate)
                // 정렬된 스트림의 최대 n개의 요소를 반환
                .limit(2)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
