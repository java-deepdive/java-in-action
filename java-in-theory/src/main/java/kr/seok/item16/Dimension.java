package kr.seok.item16;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.beans.Transient;

public class Dimension extends Dimension2D implements java.io.Serializable {

    public int width;
    public int height;

    private static final long serialVersionUID = 4723952579491349524L;

    private static native void initIDs();

    static {
        /* ensure that the necessary native libraries are loaded */
//        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
    }

    // 부 생성자들
    public Dimension() {
        this(0, 0);
    }

    public Dimension(Dimension d) {
        this(d.width, d.height);
    }

    // 주 생성자
    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // 문제가 될 수 있는 메서드
    public void setSize(double width, double height) {
        this.width = (int) Math.ceil(width);
        this.height = (int) Math.ceil(height);
    }

    @Transient
    public Dimension getSize() {
        return new Dimension(width, height);
    }

    public void setSize(Dimension d) {
        setSize(d.width, d.height);
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension d = (Dimension) obj;
            return (width == d.width) && (height == d.height);
        }
        return false;
    }

    public int hashCode() {
        int sum = width + height;
        return sum * (sum + 1) / 2 + width;
    }

    public String toString() {
        return getClass().getName() + "[width=" + width + ",height=" + height + "]";
    }
}
