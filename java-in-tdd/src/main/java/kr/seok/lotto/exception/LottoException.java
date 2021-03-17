package kr.seok.lotto.exception;

public class LottoException extends RuntimeException {
    public LottoException() { }
    public LottoException(String message) {
        super(message);
    }
}
