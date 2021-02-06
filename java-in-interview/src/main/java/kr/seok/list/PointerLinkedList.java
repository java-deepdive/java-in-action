package kr.seok.list;

import java.util.Comparator;

/**
 * 단방향 리스트에 대한 특징만 구현
 * - 각 노드는 다음 노드를 가리킨다.
 * - 배열처럼 특정 인덱스를 상수 시간에 접근할 순 없다.
 * - 시작 지점에서 아이템을 추가하거나(add(idx, element)), 삭제하는 연산(remove(idx))을 상수 시간에 할 수 있다.
 *
 * 용어
 *  - 리스트의 데이터: Node 또는 element
 *  - 노드의 구성: 데이터와 다음 노드를 가리키는 포인터
 *  - 처음(head node)과 끝(tail node)에 있는 노드
 *
 * @see java.util.ArrayList
 * @see java.util.LinkedList
 */
public class PointerLinkedList<E> {

    /**
     * 연결리스트(LinkedList)에서 사용되는 데이터를 저장하는 컨테이너 역할을 하는 Node 클래스
     */
    class Node<E> {
        E data;         // 데이터
        Node<E> next;   // 다음 노드를 가리키는 포인터

        Node(E element, Node<E> next) {
            this.data = element;
            this.next = next;
        }
    }

    Node<E> head; // 헤더 노드
    Node<E> cur; // 선택 노드

    /*
        생성자는 머리 노드를 가리키는 변수 head에 null을 대입
        그 결과 노드가 하나도 없는 비어있는 연결리스트를 생성

        이 개념을 통해 알 수 있는 것
            - 연결리스트가 비어있는지 확인 하는 방법 -> head == null
            - 노드가 1개인 연결리스트를 판단하는 방법 -> head.next == null
            - 노드가 2개인 연결리스트를 판단하는 방법 -? head.next.next == null
            - tail 노드인지 판단하는 방법 -> node.next == null
     */
    public PointerLinkedList() {
        head = cur = null;
    }

    public E search(E target, Comparator<? super E> c) {
        Node<E> ptr = head; // 스캔 중인 노드를 head로 초기화

        while (ptr != null) { // 스캔 중인 노드가 null이 아닌 경우 계속 search

            // 검색에 성공하는 경우 0, compare 에 대한 개념 필요
            if(c.compare(target, ptr.data) == 0) {
                cur = ptr; // 포인터 값을 선택 노드에 저장
                return cur.data; // 선택된 노드의 데이터를 반환
            }
            ptr = ptr.next; // 다음 노드를 선택
        }
        return null; // 검색 실패
    }

    public void addFirst(E e) {
        Node<E> ptr = head;
        head = cur = new Node<E>(e, ptr);
    }

    public void addLast(E e){
        if(head == null) addFirst(e);
        else {
            Node<E> ptr = head;
            // while 문을 종료 시, ptr은 꼬리 노드를 가리킨다.
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            // tail 노드의 특징
            ptr.next = cur = new Node<E>(e, null);
        }
    }

    /**
     * 머리 노드를 삭제하는 removeFirst 메서드
     * 리스트가 비어있지 않은경우에만 삭제를 실행
     */
    public void removeFirst() {
        if(head != null) {
            /*
                현재 head를 없애고, 다음 노드를 head로 덮어쓰기

                노드가 하나뿐인 경우 ?

                head를 없애는 방법은 다음 노드의 값이 null 값을 head에 저장
             */
            head = cur = head.next;
        }
    }

    public void removeLast() {
        if(head != null) {
            if(head.next == null) { // 노드가 하나만 있는 경우
                removeFirst(); // 머리 노드를 삭제
            } else {
                Node<E> ptr = head; // 스캔중인 노드
                Node<E> pre = head; // 스캔 중인 노드의 앞 노드

                // while문 종료 시, ptr은 꼬리 노드를 가리키고, pre 꼬리로부터 두 번째 노드를 가리킨다.
                while (ptr.next != null) {
                    pre = ptr; // 다음 포인터 값이 있는 경우 pre Node에 저장
                    ptr = ptr.next; // 다음 포인터를 현 포인터로 저장
                }
                pre.next = null; // pre는 삭제 후의 꼬리 노드
                cur = pre;
            }
        }
    }

    /*

     */
    public void remove(Node p) {
        if(head != null) {
            if(p == head) {
                removeFirst();
            } else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    ptr = ptr.next;

                    if(ptr == null) {
                        return;
                    }

                    ptr.next = p.next;
                    cur = ptr;
                }
            }
        }
    }

    public void removeCurrentNode() {
        remove(cur);
    }

    public void clear() {
        while (head != null) {
            removeFirst();
        }
        cur = null;
    }

    // 해당 노드가 존재하는지 확인하는 메서드
    public boolean next() {
        if(cur == null || cur.next == null) {
            return false;
        }
        cur = cur.next;
        return true;
    }

    // 현재 노드의 데이터를 조회
    public void printCurrentNode() {
        if(cur == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println(cur.data);
        }
    }

    // 내용 출력
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
