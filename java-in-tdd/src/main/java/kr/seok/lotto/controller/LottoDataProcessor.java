package kr.seok.lotto.controller;

import kr.seok.lotto.view.dto.RequestDto;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class LottoDataProcessor {
    private final RequestDto requestDto;

    public LottoDataProcessor(RequestDto requestDto) {
        this.requestDto = requestDto;
    }

    public Set<Integer> getSplitAndParseIntNumbers(String s) {
        return Arrays.stream(s.split(","))
                .map(Integer::valueOf)
                .collect(toSet());
    }
}
