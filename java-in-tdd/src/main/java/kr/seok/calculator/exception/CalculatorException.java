package kr.seok.calculator.exception;

public class CalculatorException extends RuntimeException {
    public CalculatorException() {
    }

    public CalculatorException(String message) {
        super(message);
    }
}
