package kr.seok.item16.book;

import java.awt.geom.Dimension2D;
import java.io.Serializable;

public class AdvancedDimension extends Dimension2D implements Serializable {

    // 필드의 접근 제한자를 public -> private 로 수정
    private int width;
    private int height;

    // 주 생성자
    public AdvancedDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    // 수정자를 제공
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSize(Dimension d) {
        setSize(d.width, d.height);
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setSize(double width, double height) {
        this.width = (int) Math.ceil(width);
        this.height = (int) Math.ceil(height);
    }
}
