package kr.seok.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericSolution1_1Stack<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    // Object -> E
    private E[] elements;
    private int size = 0;

    // 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
    // 따라서 타입 안전성을 보장하지만, 이 배열의 런타임 타입은 E[]가 아닌 Object[]이다.
    @SuppressWarnings("unchecked")
    public GenericSolution1_1Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; // 오류 대신 경고
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
