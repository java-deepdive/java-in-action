package kr.seok.calculator.v2;

public class Operand {
    private final double value;

    public Operand(double value) {
        this.value = value;
    }

    public Operand(String input) {
        this(Double.parseDouble(input));
    }

    public double value() {
        return value;
    }
}