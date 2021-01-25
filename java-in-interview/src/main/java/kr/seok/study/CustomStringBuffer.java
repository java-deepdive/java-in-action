package kr.seok.study;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Java 라이브러리 분석 <br>
 *  - Thread safe StringBuffer
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
    public synchronized CustomStringBuffer delete(int start, int end) {
        super.delete(start, end);
        return this;
    }

    @Override
    public synchronized CustomStringBuffer reverse() {
        super.reverse();
        return this;
    }

    @Override
    public synchronized String toString() {
        return new String(
                Arrays.copyOfRange(value, 0, count)
        );
    }
}

