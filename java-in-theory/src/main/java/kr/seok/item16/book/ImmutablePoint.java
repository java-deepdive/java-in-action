package kr.seok.item16.book;

import java.io.Serializable;

public class ImmutablePoint implements Serializable {
    private final int x;
    private final int y;

    private ImmutablePoint() {
        this(0, 0);
    }

    private ImmutablePoint(ImmutablePoint p) {
        this(p.x, p.y);
    }

    private ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static ImmutablePoint valueOf(ImmutablePoint p) {
        return new ImmutablePoint(p.x, p.y);
    }

    public static ImmutablePoint valueOf(double x, double y) {

        int localX = (int) Math.floor(x + 0.5);
        int localY = (int) Math.floor(y + 0.5);

        return new ImmutablePoint(localX, localY);
    }

    public ImmutablePoint location() {
        return new ImmutablePoint();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // 불변 객체로 만들기엔 이미 수정자는 구현하도록 하고 있어 문제가 될 수 있음
}
