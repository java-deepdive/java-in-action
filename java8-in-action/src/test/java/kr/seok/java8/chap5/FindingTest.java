package kr.seok.java8.chap5;

import kr.seok.java8.chap4.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static kr.seok.java8.chap4.Dish.menu;
import static org.assertj.core.api.Assertions.assertThat;

class FindingTest {

    @Test
    @DisplayName("검색과 매칭: 적어도 한 요소와 일치하는지 확인")
    void testCase1() {
        // vegetarian인지 확인하는 Predicate
        Predicate<Dish> isVegetarian = Dish::isVegetarian;

        boolean containsData = menu.stream()
                .anyMatch(isVegetarian);
        assertThat(containsData).isTrue();
    }

    @Test
    @DisplayName("검색과 매칭: 모든 요소와 일치하는지 검사")
    void testCase2() {
        Predicate<Dish> dishCaloriesLessThan1000 = d -> d.getCalories() < 1000;

        boolean isTrue = menu.stream()
                // 모든 요소와 일치하는 지 확인하는 Predicate
                .allMatch(dishCaloriesLessThan1000);

        assertThat(isTrue).isTrue();
    }


    @Test
    @DisplayName("검색과 매칭: 모든 요소와 일치하지 않는지 검사")
    void testCase3() {
        // 1000이상 칼로리
        Predicate<Dish> dishCaloriesEqualToGreater1000 = d -> d.getCalories() >= 1000;

        boolean noneMatchDishes = menu.stream()
                // 스트림에 존재하지 않는지 확인하는 연산
                .noneMatch(dishCaloriesEqualToGreater1000);

        assertThat(noneMatchDishes).isTrue();
    }

    @Test
    @DisplayName("검색과 매칭: 현재 스트림에서 임의의 요소를 반환")
    void testCase4() {
        Consumer<Dish> printDish = System.out::println;

        menu.stream()
                .filter(Dish::isVegetarian)
                // vegetarian인 어떤 값이든 조회
                .findAny()
                // 존재하면 실행 아니면 아무 일도 일어나지 않음
                .ifPresent(printDish);
    }

    @Test
    @DisplayName("검색과 매칭: 첫 번 요소 찾기")
    void testCase5() {
        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);

        Function<Integer, Integer> integerIntegerFunction = x -> x * x;

        // 스트림 연산 조건
        Predicate<Integer> integerPredicate = x -> x % 3 == 0;

        someNumbers.stream()
                .map(integerIntegerFunction)
                .filter(integerPredicate)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
