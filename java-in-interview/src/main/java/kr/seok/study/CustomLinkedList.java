package kr.seok.study;

import java.util.*;

public class CustomLinkedList<E> {

    /**
     * - <strong>data</strong>: 데이터를 가리킴. <br>
     * - <strong>next</strong>: 다음 노드를 가리키는 포인터 <br>
     * - <strong>생성자</strong>: Node<E>의 생서자는 인수로 전달받은 data, next를 해당 필드에 설정
     */
    class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * head: 머리 노드를 가리킴 <br>
     * crnt: 현재 선택한 노드를 가리킴 "검색"한 노드를 선택하고, "삭제"하는 등의 용도로 사용
     */
    private Node<E> head;
    private Node<E> crnt;

    /**
     * 머리 노드를 가리키는 변수 head에 Null을 대입<br>
     * 이는 노드가 하나도 없는 비어있는 연결리스트가 생성되었다는 의미
     */
    public CustomLinkedList() {
        head = crnt = null;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head; // 현재 스캔중인 노드

        while(ptr != null) {
            if(c.compare(obj, ptr.data) == 0) { // 검색 성공
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next; // 다음 노드 선택
        }
        return null; // 검색 실패
    }

    /**
     * 머리에 노드를 삽입하는 메서드
     */
    public void addFirst(E obj) {
        Node<E> ptr = head; // 삽입 전의 머리 노드
        head = crnt = new Node<E>(obj, ptr);
    }
}
