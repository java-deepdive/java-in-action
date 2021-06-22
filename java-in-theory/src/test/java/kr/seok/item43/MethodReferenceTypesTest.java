package kr.seok.item43;

import kr.seok.item43.MethodReferenceTypes.DataContainer;
import kr.seok.item43.MethodReferenceTypes.DataContainer.DataId;
import org.apache.commons.collections4.Factory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.*;
import java.util.function.Supplier;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MethodReferenceTypesTest {

    @DisplayName("메서드 참조 유형 - 정적 메서드 테스트")
    @Test
    void testCase1() {
        List<String> items = Arrays.asList("1", "2");

        Integer[] integers = items.stream()
//                .map(s -> Integer.parseInt(s))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        assertThat(integers).containsExactly(1, 2);
    }

    @DisplayName("메서드 참조 유형 - 정적 메서드 테스트2")
    @Test
    void testCase2() {
        List<String> items = Arrays.asList("1", "2");

        int[] ints = items.stream()
                .mapToInt(value -> new Integer(value))
//                .mapToInt(Integer::new)
                .toArray();

        assertThat(ints).containsExactly(1, 2);
    }

    @DisplayName("메서드 참조 유형 - 한정적 인스턴스 테스트1")
    @Test
    void testCase3() {
        Instant now = Instant.now();

        boolean after = now.isAfter(Instant.now());

        assertThat(after).isFalse();
    }

    @DisplayName("메서드 참조 유형 - 한정적 인스턴스 테스트2")
    @Test
    void testCase4() throws InterruptedException {
        List<Instant> instantList = Arrays.asList(Instant.now(), Instant.now());

        Thread.sleep(100);

        Instant now = Instant.now();

        // 과거 데이터와 현재 데이터의 값 비교
        instantList.forEach(item ->
                assertThat(item.isBefore(now)).isTrue()
        );
    }

    @DisplayName("메서드 참조 유형 - 비한정적 인스턴스 테스트1")
    @Test
    void testCase5() {
        String[] lowerStr = {"hello", "world"};

        String[] strings = Arrays.stream(lowerStr)
                .map(str -> str.toUpperCase())
                .toArray(String[]::new);

        assertAll(
                () -> assertThat(strings[0]).isEqualTo(lowerStr[0].toUpperCase()),
                () -> assertThat(strings[1]).isEqualTo(lowerStr[1].toUpperCase())
        );
    }

    @DisplayName("메서드 참조 유형 - 클래스 생성 테스트")
    @Test
    void testCase6() {

        Supplier<TreeMap> treeMapSupplier = () -> new TreeMap<>();
        Factory<TreeMap> treeMapFactory = () -> new TreeMap<>();

        assertThat(treeMapSupplier).isInstanceOf(Supplier.class);
        assertThat(treeMapFactory).isInstanceOf(Factory.class);
    }

    @DisplayName("메서드 참조 유형 - 배열 생성 테스트")
    @Test
    void testCase7() {
        Function<Integer, int[]> intSupplier = len -> new int[len];

        int[] apply = intSupplier.apply(3);

        assertThat(apply).hasSize(3);
    }
}
