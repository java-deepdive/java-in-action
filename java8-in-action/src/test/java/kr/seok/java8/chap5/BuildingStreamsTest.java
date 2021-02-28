package kr.seok.java8.chap5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BuildingStreamsTest {

    @Test
    @DisplayName("값으로 스트림 만들기")
    void testCase1() {
        Stream
                .of("Java 8", "Lambdas", "In", "Action")
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("배열로 스트림 만들기")
    void testCase2() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        assertThat(sum).isEqualTo(41);
    }

    @Test
    @DisplayName("파일 내에 각 행 요소를 반환하는 스트림 얻어오기")
    void testCase3() {
        try {

            long count = Files.lines(Paths.get("src/main/resources/files/data.txt"), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();

            assertThat(count).isEqualTo(5L);
            System.out.println("There are " + count + " unique words in data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("함수로 무한 스트림(언바운드 스트림)만들기")
    void testCase4() {
        // 연속된 일련의 값을 만들때 iterate 사용
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("iterate 사용 방법")
    void testCase5() {
        // iterate 로 정수형 배열로 반환하기
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        // iterate 로 피보나치 수열을 생성
        Stream.iterate(new int[]{0, 1},
                // 배열을 전달하며 새로운 배열을 생성
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(i -> System.out.print(i + " -> "));
        System.out.println();
    }

    @Test
    @DisplayName("generate 사용 방법")
    void testCase6() {
        // Supplier를 이용한 0 ~ 1사이의 랜덤한 double을 생성
        Supplier<Double> random = Math::random;
        Stream.generate(random)
                .limit(10)
                .forEach(System.out::println);

        // IntSupplier 를 이용한 값의 생성
        IntSupplier intSupplier = () -> 1;

        IntStream.generate(intSupplier)
                .limit(5)
                .forEach(System.out::println);

        IntSupplier intSupplier2 = new IntSupplier() {
            public int getAsInt() {
                return 2;
            }
        };
        IntStream.generate(intSupplier2)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("불변 상태 기법의 필요성")
    void testCase7() {
        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        IntStream.generate(fib)
                .limit(10).forEach(System.out::println);
    }
}
