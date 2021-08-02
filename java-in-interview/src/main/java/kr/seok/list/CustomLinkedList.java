package kr.seok.list;

import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList<E> extends AbstractSequentialList<E> implements List<E> {

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;
    public CustomLinkedList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

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

}
