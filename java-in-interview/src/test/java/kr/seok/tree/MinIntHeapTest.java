package kr.seok.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MinIntHeapTest {

    @Test
    @DisplayName("최소 힙 add() 테스트")
    void testCase1() {

        MinIntHeap heap = new MinIntHeap();

        heap.add(5);
        heap.add(3);
        heap.add(10);

        Arrays.stream(heap.items)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("최소 힙 pop() 테스트")
    void testCase2() {
        MinIntHeap heap = new MinIntHeap();

        heap.add(28);
        heap.add(14);
        heap.add(10);
        heap.add(5);
        heap.add(12);
        heap.add(3);
        heap.add(22);

        assertThat(heap.poll()).isEqualTo(3);

        Arrays.stream(heap.items)
                .forEach(System.out::println);

    }
}
