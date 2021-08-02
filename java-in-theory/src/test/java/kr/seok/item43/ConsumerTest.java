package kr.seok.item43;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ConsumerTest {

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }

    @DisplayName("제네릭 형식 T 객체를 받아서 void 를 반환하는 accept라는 추상 메서드를 정의")
    @Test
    void testCase1() {
        forEach(
                Arrays.asList("1", "2", "3"),
                (String i) -> System.out.println("i = " + i)
        );
    }
}
