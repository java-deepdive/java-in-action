package kr.seok.item16.book;

import java.awt.geom.Point2D;
import java.beans.Transient;
import java.io.Serializable;
import java.util.Objects;

public class AdvancedPoint extends Point2D implements Serializable {

    // 필드의 접근 제한자를 public -> private 으로 공개하지 않도록 설계
    private int x;
    private int y;

    public AdvancedPoint() {
        this(0, 0);
    }

    public AdvancedPoint(Point p) {
        this(p.x, p.y);
    }

    public AdvancedPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 수정자를 제공
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Transient
    public Point getLocation() {
        return new Point(x, y);
    }

    public void setLocation(Point p) {
        setLocation(p.x, p.y);
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = (int) Math.floor(x + 0.5);
        this.y = (int) Math.floor(y + 0.5);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdvancedPoint)) return false;
        if (!super.equals(o)) return false;
        final AdvancedPoint that = (AdvancedPoint) o;
        return getX() == that.getX()
                && getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getX(), getY());
    }
}
