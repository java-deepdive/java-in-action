package kr.seok.lotto.generator;


import kr.seok.lotto.domain.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<LottoNumber> generate();
}
