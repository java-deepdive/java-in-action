package kr.seok.lotto.controller;


import kr.seok.lotto.domain.Lotto;
import kr.seok.lotto.service.LottoFactory;
import kr.seok.lotto.service.Lottos;
import kr.seok.lotto.view.dto.ManualLottoParser;
import kr.seok.lotto.view.dto.RequestLottoArgument;

import java.util.List;

/**
 * 유저와 로또 사이 판매자 역할
 */
public class LottoStore {

    public Lottos issueLotto(final RequestLottoArgument argument, final ManualLottoParser manualLottoParser) {
        return new Lottos(getManualAndAuto(argument.autoSize(), manualLottoParser));
    }

    private List<Lotto> getManualAndAuto(final int totalCount, final ManualLottoParser manualLottoParser) {
        return LottoFactory.mergeManualAndAuto(totalCount, manualLottoParser);
    }
}
