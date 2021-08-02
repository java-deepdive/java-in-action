package kr.seok.lotto.domain.type;

import java.util.Arrays;

/**
 * 로또 당첨 순위와 당첨금액에 대한 상수 값을 정의 하는 열거 타입
 */
public enum LottoMatch {
    /**
     * 순위 1: 매칭되는 숫자 6개, 20억
     */
    RANK_FIRST(6, 2_000_000_000),
    /**
     * 순위 2: 매칭되는 숫자 5개 + 보너스 숫자, 3천만원
     */
    RANK_BONUS(5, 30_000_000),
    /**
     * 순위 2: 매칭되는 숫자 5개, 150만원
     */
    RANK_SECOND(5, 1_500_000),
    /**
     * 순위 4: 매칭되는 숫자 4개, 5만원
     */
    RANK_THIRD(4, 50_000),
    /**
     * 순위 5: 매칭되는 숫자 3개, 5천원
     */
    RANK_FOURTH(3, 5_000),
    /**
     * 그 외: 매칭되는 숫자 2개 이하, 0원
     */
    RANK_ETC(0, 0);

    private final long matchCount;
    private final long winningReward;

    LottoMatch(final long matchCount, final long winningReward) {
        this.matchCount = matchCount;
        this.winningReward = winningReward;
    }

    /**
     * RANK_ETC 외에 당첨 금액 값이 존재하는 필드 리스트를 반환
     *
     * @return 해당 열거 타입에 정의된 필드 조회
     */
    public static LottoMatch[] all() {
        return new LottoMatch[]{RANK_FOURTH, RANK_THIRD, RANK_SECOND, RANK_BONUS, RANK_FIRST};
    }

    /**
     * 로또 당첨 확인 메서드
     *
     * @param matchCount  매칭되는 로또 번호 갯수
     * @param bonusNumber 보너스 숫자 매칭 여부
     * @return 매핑된 로또 필드 반환
     */
    public static LottoMatch of(final long matchCount, final boolean bonusNumber) {
        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.isMatchCount(matchCount))
                .filter(lottoMatch -> lottoMatch.isBonusNumber(bonusNumber))
                .findFirst()
                .orElse(RANK_ETC);
    }

    /**
     * 보너스 번호 매핑 여부 확인
     *
     * @param bonusNumber 보너스 번호 당첨 여부
     * @return 보너스 번호 매핑 여부
     */
    public boolean isBonusNumber(final boolean bonusNumber) {
        return !this.equals(RANK_BONUS) || bonusNumber;
    }

    private boolean isMatchCount(final long matchCount) {
        return this.matchCount == matchCount;
    }

    /**
     * 로또 당첨 금액 반환
     *
     * @return 당첨금
     */
    public long getWinningReward() {
        return winningReward;
    }

    @Override
    public String toString() {
        return String.valueOf(matchCount);
    }
}
