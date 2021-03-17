package kr.seok.lotto.controller;


import kr.seok.lotto.domain.Lotto;
import kr.seok.lotto.service.Lottos;
import kr.seok.lotto.view.dto.RequestMoney;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 유저와 로또 사이 중개자 역할
 */
public class LottoGame {

    public Lottos buyLotto(final RequestMoney money) {
        int totalLottoCount = money.getTotalLottoCount();
        List<Lotto> collect = Stream.generate(Lotto::new)
                .limit(totalLottoCount)
                .collect(Collectors.toList());
        return new Lottos(collect);
    }

}
