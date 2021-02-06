package kr.seok.java8.chap1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FilteringApplesTest {

    FilteringApples apples;

    @BeforeEach
    void setUp() {
        apples = new FilteringApples();
    }

    private List<Apple> getApples() {
        return Arrays.asList(
                new Apple(50, "brown"),
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );
    }

    /**
     * 일반 필터링 방법
     *
     * Apple 리스트 -> filter (green) -> Filtering Apple
     *
     * 필터링된 리스트
     * Apple{color='green', weight=80}
     * Apple{color='green', weight=155}
     *
     */
    @Test
    @DisplayName("Apple List 색을 기준으로 필터링 테스트")
    void testCase1() {
        List<Apple> inventory = getApples();
        List<Apple> apples = this.apples.filterGreenApples(inventory);

        apples.forEach(System.out::println);

    }

    /**
     * 일반 필터링 방법
     *
     * Apple 리스트 -> filter (weight::150) -> Filtering Apple
     *
     * 필터링된 리스트
     * Apple{color='green', weight=155}
     */
    @Test
    @DisplayName("Apple List 무게를 기준으로 필터링 테스트")
    void testCase2() {
        List<Apple> inventory = getApples();
        List<Apple> apples = this.apples.filterHeavyApples(inventory);
        apples.forEach(System.out::println);
    }


    /**
     * 메서드 파라미터 테스트
     *
     * Apple{color='green', weight=80}
     * Apple{color='green', weight=155}
     */
    @Test
    @DisplayName("메서드 파라미터를 이용해 색을 기준으로 필터링 테스트")
    void testCase3() {
        List<Apple> inventory = getApples();
        List<Apple> apples = this.apples.filterApples(inventory, Apple::isGreenApple);
        apples.forEach(System.out::println);
    }

    /**
     * 메서드 파라미터 테스트
     *
     * Apple{color='green', weight=155}
     */
    @Test
    @DisplayName("메서드 파라미터를 이용해 무게를 기준으로 필터링 테스트")
    void testCase4() {
        List<Apple> inventory = getApples();
        List<Apple> apples = this.apples.filterApples(inventory, Apple::isHeavyApple);
        apples.forEach(System.out::println);
    }

    /**
     * 람다 테스트
     *
     * Apple{color='green', weight=80}
     * Apple{color='green', weight=155}
     */
    @Test
    @DisplayName("람다를 이용해 색을 기준으로 필터링 테스트")
    void testCase5() {
        List<Apple> inventory = getApples();
        List<Apple> apples = this.apples.filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        apples.forEach(System.out::println);
    }

    /**
     * 람다 테스트
     *
     * Apple{color='green', weight=155}
     */
    @Test
    @DisplayName("람다를 이용해 무게를 기준으로 필터링 테스트")
    void testCase6() {
        List<Apple> inventory = getApples();
        List<Apple> apples = this.apples.filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        apples.forEach(System.out::println);
    }

    /**
     * 람다 테스트
     *
     * Apple{color='brown', weight=50}
     */
    @Test
    @DisplayName("람다를 이용해 색 & 무게를 기준으로 필터링")
    void testCase7() {
        List<Apple> inventory = getApples();
        List<Apple> apples = this.apples.filterApples(inventory,
                (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
        apples.forEach(System.out::println);
    }
}
