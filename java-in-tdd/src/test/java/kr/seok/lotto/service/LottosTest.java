package kr.seok.lotto.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void testCase1() {
        List<Integer> collect = IntStream.rangeClosed(1, 6)
                .boxed()
                .collect(Collectors.toList());
        Lottos lottos = Lottos.of(Arrays.asList(Lotto.of(collect)));


        assertThat(lottos).isEqualTo(Lottos.of(Arrays.asList(Lotto.of(collect))));
    }

    @Test
    void testCase2() {
        List<Integer> collect = IntStream.rangeClosed(1, 6)
                .boxed()
                .collect(Collectors.toList());

        Lottos lottos = Lottos.of(Arrays.asList(Lotto.of(collect)));

        List<Integer> collect1 = IntStream.rangeClosed(2, 7)
                .boxed()
                .collect(Collectors.toList());

        Lottos merge = lottos.merge(Arrays.asList(Lotto.of(collect1)));

        merge.getLottoList()
                .forEach(System.out::println);
    }
}
