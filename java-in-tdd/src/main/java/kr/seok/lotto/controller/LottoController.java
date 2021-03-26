package kr.seok.lotto.controller;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    static List<Integer> numbers;

    static {
        numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public Set<Integer> shuffle() {
        Collections.shuffle(numbers);
        return Collections.unmodifiableSet(data());
    }

    private Set<Integer> data() {
        return numbers.stream().limit(6)
                .collect(Collectors.toSet());
    }

    public void lotto(LottoDataProcessor lottoDataProcessor) {

    }
}
