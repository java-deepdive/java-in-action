package kr.seok.list;

import java.util.*;

public class CustomLinkedList<E> extends AbstractSequentialList<E> implements List<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public CustomLinkedList() { }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

}
