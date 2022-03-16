package kr.seok.lotto.domain.type;

import java.util.Arrays;

/**
 * 로또 당첨 순위와 당첨금액에 대한 상수 값을 정의 하는 열거 타입
 */
public enum LottoMatch {

	RANK_FIRST(6, 2_000_000_000),
	RANK_BONUS(5, 30_000_000),
	RANK_SECOND(5, 1_500_000),
	RANK_THIRD(4, 50_000),
	RANK_FOURTH(3, 5_000),
	RANK_ETC(0, 0);

	private final long matchCount;
	private final long winningReward;

	LottoMatch(final long matchCount, final long winningReward) {
		this.matchCount = matchCount;
		this.winningReward = winningReward;
	}

	public static LottoMatch[] all() {
		return new LottoMatch[]{RANK_FOURTH, RANK_THIRD, RANK_SECOND, RANK_BONUS, RANK_FIRST};
	}

	public static LottoMatch of(final long matchCount, final boolean bonusNumber) {
		return Arrays.stream(LottoMatch.values())
				.filter(lottoMatch -> lottoMatch.isMatchCount(matchCount))
				.filter(lottoMatch -> lottoMatch.isBonusNumber(bonusNumber))
				.findFirst()
				.orElse(RANK_ETC);
	}

	public boolean isBonusNumber(final boolean bonusNumber) {
		return !this.equals(RANK_BONUS) || bonusNumber;
	}

	private boolean isMatchCount(final long matchCount) {
		return this.matchCount == matchCount;
	}

	public long getWinningReward() {
		return winningReward;
	}

	@Override
	public String toString() {
		return String.valueOf(matchCount);
	}
}
