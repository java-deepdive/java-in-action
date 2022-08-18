package kr.seok.calculator.v2;

public class Operator {
    private final OperationProcessor value;

    public Operator(OperationProcessor value) {
        this.value = value;
    }

    public Operator(String input) {
        this(OperationProcessor.of(input));
    }

    public double calculate(Operand left, Operand right) {
        return Math.round(value.calculate(left, right) * 100) / 100.0;
    }
}
