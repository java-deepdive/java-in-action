package kr.seok.lotto;

import kr.seok.lotto.controller.LottoController;
import kr.seok.lotto.domain.Money;
import kr.seok.lotto.view.InputView;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoController lottoController = new LottoController();

        int requestMoney = inputView.requestMoney(); // 돈 입력
        int manualCount = inputView.requestManual(); // 수동 숫자 몇 개 ?

        Money money = Money.of(requestMoney);

        List<Set<Integer>> sets = inputView.makeManualLottoNumbers(manualCount); // 수동 로또 번호 리스트 입력

        Set<Integer> winningNumbers = inputView.requestLastWeekWinningNumbers();// 지난 주 당첨 번호 입력


    }
}
