package kr.seok.calculator.v1.exception;

public class CalculatorException extends RuntimeException {
    public CalculatorException() {
    }

    public CalculatorException(String message) {
        super(message);
    }
}
