package kr.seok.stackNQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedBlockingQueueTest {

    private LinkedBlockingQueue<LinkedBlockingQueue.Node> queue;

    @BeforeEach
    void setUp() {
        queue = new LinkedBlockingQueue<>();
        queue.offer(new LinkedBlockingQueue.Node<>(0));
        queue.offer(new LinkedBlockingQueue.Node<>(1));
        queue.offer(new LinkedBlockingQueue.Node<>(2));
        queue.offer(new LinkedBlockingQueue.Node<>(3));
    }

    @DisplayName(value = "Queue 생성 테스트")
    @Test
    void testCase() {
        assertThat(queue.size()).isEqualTo(4);
    }

    @DisplayName(value = "Queue 입력 값 비교 테스트")
    @Test
    void testCase1() {
        // given
        LinkedBlockingQueue.Node peek = queue.peek();
        // when
        LinkedBlockingQueue.Node expected = queue.peek();
        // then
        assertThat(peek).isEqualTo(expected);
    }

    @DisplayName(value = "Queue poll 테스트")
    @Test
    void testCase2() {
        queue.poll();
        LinkedBlockingQueue.Node expected = queue.peek();
        LinkedBlockingQueue.Node actual = queue.poll();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName(value = "Queue offer 테스트")
    @Test
    void testCase3() {
        queue.offer(new LinkedBlockingQueue.Node<>(5));

        LinkedBlockingQueue.Node actual = queue.peek();
        LinkedBlockingQueue.Node expected = queue.poll();

        assertThat(actual).isEqualTo(expected);
    }
}
