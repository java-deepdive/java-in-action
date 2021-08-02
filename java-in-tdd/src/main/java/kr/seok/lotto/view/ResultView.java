package kr.seok.lotto.view;


import kr.seok.lotto.domain.Lotto;
import kr.seok.lotto.domain.LottoResult;
import kr.seok.lotto.domain.type.LottoMatch;
import kr.seok.lotto.domain.type.ProfitMessage;
import kr.seok.lotto.service.Lottos;
import kr.seok.lotto.view.dto.RequestLottoArgument;

import java.io.PrintStream;
import java.util.List;

public class ResultView {

    private static final String GUIDE_BUY_LOTTO = "%s개를 구매했습니다.%n";
    private static final String GUIDE_PROFIT = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s를 의미)%n";

    private static final PrintStream out = System.out;

    public void printLottoCount(final RequestLottoArgument requestLottoArgument) {
        out.printf(GUIDE_BUY_LOTTO, requestLottoArgument.totalSize());
    }

    public void printLottos(final Lottos lottos) {
        List<Lotto> lotteries = lottos.lottoList();
        lotteries.forEach(out::println);
        out.println();
    }

    public void printResult(final LottoResult lottoResult) {
        for (LottoMatch item : LottoMatch.all()) {
            out.println(format(item, lottoResult));
        }
        double rate = lottoResult.winningRate();
        out.printf(GUIDE_PROFIT, rate, ProfitMessage.of(rate));
    }

    private String format(final LottoMatch lottoMatch, final LottoResult lottoResult) {
        return String.format(
                printDiffBonus(lottoMatch)
                , lottoMatch
                , lottoMatch.getWinningReward()
                , lottoResult.count(lottoMatch));
    }

    private String printDiffBonus(LottoMatch match) {
        if (match.equals(LottoMatch.RANK_BONUS)) {
            return "%s 개 일치, 보너스볼 일치(%s원) - %s개";
        }
        return "%s 개 일치 (%s원) - %s개";
    }
}
