package kr.seok.java8.chap1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
     * <p>
     * Apple 리스트 -> filter (green) -> Filtering Apple
     * <p>
     * 필터링된 리스트
     * Apple{color='green', weight=80}
     * Apple{color='green', weight=155}
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
     * <p>
     * Apple 리스트 -> filter (weight::150) -> Filtering Apple
     * <p>
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
     * <p>
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
     * <p>
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
     * <p>
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
     * <p>
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
     * <p>
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

    /**
     * 컬렉션을 필터링하는 가장 빠른 방법
     * - 컬렉션을 스트림으로 바꾸고, 병렬로 처리한 다음에 리스트로 다시 복원
     * <p>
     * Apple{color='green', weight=155}
     */
    @Test
    @DisplayName("stream().filter()를 이용한 필터링")
    void testCase8() {
        List<Apple> inventory = getApples();
        List<Apple> apples = inventory.stream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(toList());

        apples.forEach(System.out::println);
    }

    /**
     * 스트림 parallelStream 처리
     * <p>
     * Apple{color='green', weight=155}
     */
    @Test
    @DisplayName("parallelStream().filter()를 이용한 필터링")
    void testCase9() {
        List<Apple> inventory = getApples();
        List<Apple> apples = inventory
                .parallelStream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(toList());

        apples.forEach(System.out::println);
    }
}
