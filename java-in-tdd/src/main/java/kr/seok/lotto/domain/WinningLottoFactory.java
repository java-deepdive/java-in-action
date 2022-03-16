package kr.seok.lotto.domain;

public class WinningLottoFactory {

	private WinningLottoFactory() {
	}

	public static WinningLotto of(final String winningLotto, final LottoNumber bonusNumber) {
		return new WinningLotto(WinningLotto.parseLotto(winningLotto), bonusNumber);
	}

	public static WinningLotto of(final String winningLotto) {
		return new WinningLotto(WinningLotto.parseLotto(winningLotto), null);
	}
}