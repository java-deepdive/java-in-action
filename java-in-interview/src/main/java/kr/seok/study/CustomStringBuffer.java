package kr.seok.study;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Java 라이브러리 분석
 * Thread safe StringBuffer
 */
public final class CustomStringBuffer extends AbstractStringBuilder implements Serializable {

    static final long serialVersionUID = 3388685877147921107L;

    // ##### ##### ##### ##### ##### ##### ##### ##### 생성자

    // default 생성자
    public CustomStringBuffer() {
        super(16);
    }

    // 버퍼 크기 조절 가능한 생성자
    public CustomStringBuffer(int capacity) {
        super(capacity);
    }

    // 문자열 저장하여 생성시 문자열의 길이를 고려하여 여유있게 생성
    public CustomStringBuffer(String str) {
        super(str.length() + 16);
        append(str);
    }

    // ##### ##### ##### ##### ##### ##### ##### ##### 메서드

    @Override
    public synchronized CustomStringBuffer append(String str) {
        super.append(str);
        return this;
    }

    @Override
    public synchronized String toString() {
        return new String(Arrays.copyOfRange(value, 0, count));
    }

    @Override
    public synchronized CustomStringBuffer delete(int start, int end) {
        super.delete(start, end);
        return this;
    }

    @Override
    public synchronized CustomStringBuffer insert(int offset, String str) {
        super.insert(offset, str);
        return this;
    }

    @Override
    public synchronized CustomStringBuffer replace(int start, int end, String str) {
        super.replace(start, end, str);
        return this;
    }

    @Override
    public synchronized CustomStringBuffer reverse() {
        super.reverse();
        return this;
    }
}

/**
 * 실질 로직을 담당하는 추상클래스
 */
abstract class AbstractStringBuilder {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    char[] value;
    int count;

    AbstractStringBuilder(int capacity) {
        value = new char[capacity];
    }

    public AbstractStringBuilder append(String str) {
        /* 문자열 없으면 null 값 넣기 */
        if (str == null) return appendNull();
        /* 문자열 길이 */
        int len = str.length();
        /* 기존에 존재하는 길이 값 + len */
        ensureCapacityInternal(count + len);

        /*
            System.arraycopy(
                    // 수정할 배열
                    value,

                    // 수정할 배열의 시작점
                    srcBegin,

                    // 기존 배열
                    dst,

                    // 기존 배열의 시작점
                    dstBegin,

                    // 변경 길이
                    srcEnd - srcBegin);
         */
        str.getChars(
                /* 수정할 배열의 시작 인덱스 */
                0,
                /* 수정할 배열의 끝 인덱스 */
                len,
                /* 기존 배열 */
                value,
                /* 현 배열의 길이 */
                count);

        count += len;
        return this;
    }

    public AbstractStringBuilder insert(int offset, String str) {
        if ((offset < 0) || (offset > length()))
            throw new StringIndexOutOfBoundsException(offset);
        if(str == null) str = "null";
        int len = str.length();
        ensureCapacityInternal(count + len);
        System.arraycopy(value, offset, value, offset + len, count - offset);
        System.arraycopy(str.toCharArray(), 0, value, offset, len);
        count += len;
        return this;
    }

    protected AbstractStringBuilder replace(int start, int end, String str) {
        if (start < 0)          throw new StringIndexOutOfBoundsException(start);
        if (start > count)      throw new StringIndexOutOfBoundsException("start > length()");
        if (start > end)        throw new StringIndexOutOfBoundsException("start > end");

        if (end > count)        end = count;

        int len = str.length();
        int newCount = count + len - (end - start);
        char[] dest = str.toCharArray();

        ensureCapacityInternal(newCount);
        System.arraycopy(value, end, value, start + len, count - end);
        System.arraycopy(dest, 0, value, start, dest.length);
        count = newCount;
        return this;
    }

    public AbstractStringBuilder delete(int start, int end) {
        if (start < 0)      throw new StringIndexOutOfBoundsException(start);
        if (end > count)    end = count;
        if (start > end)    throw new StringIndexOutOfBoundsException();

        int len = end - start;
        if (len > 0) {
            System.arraycopy(value, start+len, value, start, count-end);
            count -= len;
        }
        return this;
    }

    /**
     * buffer 배열 null 값 처리
     */
    private AbstractStringBuilder appendNull() {
        int c = count;
        ensureCapacityInternal(c + 4);
        final char[] value = this.value;

        value[c++] = 'n';
        value[c++] = 'u';
        value[c++] = 'l';
        value[c++] = 'l';
        count = c;

        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        // overflow-conscious code
        if (minimumCapacity - value.length > 0) {
            value = Arrays.copyOf(value, newCapacity(minimumCapacity));
        }
    }

    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int newCapacity = (value.length << 1) + 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
                ? hugeCapacity(minCapacity)
                : newCapacity;
    }

    private int hugeCapacity(int minCapacity) {
        if (Integer.MAX_VALUE - minCapacity < 0) { // overflow
            throw new OutOfMemoryError();
        }
        return Math.max(minCapacity, MAX_ARRAY_SIZE);
    }

    @Override
    public abstract String toString();

    public int length() {
        return count;
    }

    protected AbstractStringBuilder reverse() {
        boolean hasSurrogates = false;
        int n = count - 1;

        System.out.println((n-1));
        for (int j = (n-1) >> 1; j >= 0; j--) {
            System.out.println(j);
            int k = n - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
            if (Character.isSurrogate(cj) || Character.isSurrogate(ck)) {
                hasSurrogates = true;
            }
        }
        if (hasSurrogates) {
            reverseAllValidSurrogatePairs();
        }
        return this;
    }

    private void reverseAllValidSurrogatePairs() {
        for (int i = 0; i < count - 1; i++) {
            char c2 = value[i];
            if (Character.isLowSurrogate(c2)) {
                char c1 = value[i + 1];
                if (Character.isHighSurrogate(c1)) {
                    value[i++] = c1;
                    value[i] = c2;
                }
            }
        }
    }
}
