package kr.seok.item10;

public class EqualsSubject {

    private final Float aFloat;

    public EqualsSubject(Float aFloat) {
        this.aFloat = aFloat;
    }

    public static void main(String[] args) {
        EqualsSubject equalsSubject = new EqualsSubject(1.1f);
        equalsSubject.aFloat.equals(1.2f);

    }
}
