package kr.seok.stackNQueue;

import java.util.EmptyStackException;

public class SimpleStack<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data; // top 의 데이터를 임시 값으로 저장
        top = top.next; // top 의 다음 값을 top 으로 저장
        return item; // 임시 저장했던 data를 반환
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
