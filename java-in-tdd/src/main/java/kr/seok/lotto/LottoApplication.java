package kr.seok.lotto;


import kr.seok.lotto.controller.LottoStore;
import kr.seok.lotto.domain.LottoNumber;
import kr.seok.lotto.domain.LottoResult;
import kr.seok.lotto.domain.Money;
import kr.seok.lotto.domain.WinningLotto;
import kr.seok.lotto.service.Lottos;
import kr.seok.lotto.view.InputView;
import kr.seok.lotto.view.ResultView;
import kr.seok.lotto.view.dto.ManualLottoParser;
import kr.seok.lotto.view.dto.RequestLottoArgument;

public class LottoApplication {

    public void step4() {
        InputView inputView = new InputView();
        LottoStore lottoStore = new LottoStore();
        ResultView resultView = new ResultView();

        Money money = Money.of(inputView.requestPurchasedLotto());
        String manualCount = inputView.requestManual();
        RequestLottoArgument lottoArgument = RequestLottoArgument.of(money, manualCount);

        ManualLottoParser manualArgument = ManualLottoParser.of(inputView.makeManualLottoNumbers(manualCount));
        resultView.printLottoCount(lottoArgument);

        Lottos lottos = lottoStore.issueLotto(lottoArgument, manualArgument);
        resultView.printLottos(lottos);

        String winningNumbers = inputView.requestWinningNumbers();
        LottoNumber bonusNumber = LottoNumber.of(inputView.requestBonusNumber());

        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

        LottoResult lottoResult = LottoResult.of(lottos, winningLotto);
        resultView.printResult(lottoResult);
    }

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        lottoApplication.step4();
    }
}
