package kr.seok.study;

import java.io.Serializable;

/**
 * StringBuilder
 */
public final class CustomStringBuilder extends AbstractStringBuilder implements Serializable {

    public CustomStringBuilder() {
        super(16);
    }

    public CustomStringBuilder(int capacity) {
        super(capacity);
    }

    public CustomStringBuilder(String str) {
        super(str.length() + 16);
        append(str);
    }

    @Override
    public AbstractStringBuilder append(String str) {
        super.append(str);
        return this;
    }

    @Override
    public AbstractStringBuilder insert(int offset, String str) {
        super.insert(offset, str);
        return this;
    }

    @Override
    protected AbstractStringBuilder replace(int start, int end, String str) {
        super.replace(start, end, str);
        return this;
    }

    @Override
    public AbstractStringBuilder delete(int start, int end) {
        super.delete(start, end);
        return this;
    }

    @Override
    protected AbstractStringBuilder reverse() {
        return super.reverse();
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}
