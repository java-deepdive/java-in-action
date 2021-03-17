package kr.seok.lotto;


import kr.seok.lotto.controller.LottoGame;
import kr.seok.lotto.domain.LottoResult;
import kr.seok.lotto.service.Lottos;
import kr.seok.lotto.view.InputView;
import kr.seok.lotto.view.ResultView;
import kr.seok.lotto.view.dto.RequestMoney;
import kr.seok.lotto.view.dto.RequestWinningNumber;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoGame lottoGame = new LottoGame();

        // 금액 요청
        RequestMoney requestMoney = InputView.requestMoney();
        resultView.printBuyCount(requestMoney);
        Lottos lottos = lottoGame.buyLotto(requestMoney);

        // 중간 보기
        resultView.printBuyLottos(lottos);

        // 당첨 번호 입력
        RequestWinningNumber winningNumber = inputView.requestWinningNumber();
        LottoResult lottoResult = new LottoResult(requestMoney, winningNumber, lottos);
        // 결과 보기
        resultView.printStatics(lottoResult);
        resultView.printRate(lottoResult);
    }
}
