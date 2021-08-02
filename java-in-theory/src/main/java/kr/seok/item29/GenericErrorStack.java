package kr.seok.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericErrorStack<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    // Object -> E
    private E[] elements;
    private int size = 0;

    public GenericErrorStack() {
        //elements = new E[DEFAULT_INITIAL_CAPACITY]; // 에러 발생!
        // 실체화 불가 타입으로는 배열을 만들 수 없음.
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        E result = elements[--size];
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
