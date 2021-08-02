package kr.seok.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericSolution1_2Stack<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    // Object -> E
    private E[] elements;
    private int size = 0;

    public GenericSolution1_2Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; // 오류 대신 경고
        // 제네릭 배열 생성을 금지하는 제약을 대놓고 우회하는 방법
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
