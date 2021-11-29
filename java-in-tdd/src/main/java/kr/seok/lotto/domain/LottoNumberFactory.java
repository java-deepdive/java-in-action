package kr.seok.lotto.domain;

public class LottoNumberFactory {

    private LottoNumberFactory() {}

    public static LottoNumber of(final String number) {
        return new LottoNumber(number);
    }

    public static LottoNumber of(final int number) {
        return new LottoNumber(number);
    }
}