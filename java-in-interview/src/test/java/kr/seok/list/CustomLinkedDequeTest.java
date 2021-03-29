package kr.seok.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomLinkedDequeTest {

    CustomLinkedDeque<CustomLinkedDeque.Node> deque;

    @BeforeEach
    void setUp() {
        deque = new CustomLinkedDeque<>();
    }

    @DisplayName(value = "LinkedList implements Deque 테스트")
    @Test
    void testCase1() {
        // given
        CustomLinkedDeque.Node<Integer> node = new CustomLinkedDeque.Node<>(1);
        // when
        deque.offer(node);
        Object peek = deque.peek();
        // then
        assertThat(peek).isEqualTo(new CustomLinkedDeque.Node(1));
    }

    @Test
    void testCase2() {

    }
}
