package kr.seok.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class PointerLinkedListTest {

    PointerLinkedList<Integer> linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new PointerLinkedList<>();
    }

    @Test
    @DisplayName("생성 및 노드가 존재하는지 확인")
    void testCase1() {
        boolean next = linkedList.next();
        assertThat(next).isFalse(); // LinkedList 내에 존재하는 노드가 없음을 확인
        assertThat(linkedList.head == null).isTrue();
    }

    @Test
    @DisplayName("addLast()와 노드 1개 연결 리스트를 판단하는 테스트")
    void testCase2() {
        linkedList.addLast(1);
        // 헤더부터 연결된 노드들을 순차적으로 조회
        linkedList.dump();

        // 노드 1개임을 확인하는 방법
        assertThat(linkedList.head.next == null).isTrue();
    }

    @Test
    @DisplayName("연속적인 데이터 추가 테스트")
    void testCase3() {
        appendLinkedList();
        linkedList.dump();
    }

    @Test
    @DisplayName("addFirst() 테스트")
    void testCase4() {
        // 1, 2, 3
        appendLinkedList();
        // 0, 1, 2, 3
        linkedList.addFirst(0);
        linkedList.dump();
    }

    // 1, 2, 3
    private void appendLinkedList() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
    }

    @Test
    @DisplayName("데이터 조회 메서드 테스트")
    void testCase5() {
        appendLinkedList();
        linkedList.search(2, NO_ORDER);
    }

    private static class NoOrderComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
    public static final Comparator<Integer> NO_ORDER = new NoOrderComparator();

    @Test
    @DisplayName("removeFirst() 메서드 테스트")
    void testCase6() {
        appendLinkedList();
        // head 노드 제거
        linkedList.removeFirst();
        linkedList.dump();
    }

    @Test
    @DisplayName("removeLast() 메서드 테스트")
    void testCase7() {
        appendLinkedList();
        // tail 노드 제거
        linkedList.removeLast();
        linkedList.dump();
    }

    @Test
    @DisplayName("removeCurrentNode() 메서드 테스트")
    void testCase8() {
        appendLinkedList();
        linkedList.dump();
        System.out.println("removeCurrentNode 수행 후");
        linkedList.removeCurrentNode();
        linkedList.dump();
    }
}
