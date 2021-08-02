package kr.seok.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericSolution2_1Stack<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    // Object -> E
    private Object[] elements;
    private int size = 0;

    public GenericSolution2_1Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 비검사 경고를 적절히 숨긴다.
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        // push에서 E 타입만 허용하므로 이 형변환은 안전하다.
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];

        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
