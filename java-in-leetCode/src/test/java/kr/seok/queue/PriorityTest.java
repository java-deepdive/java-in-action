package kr.seok.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

class PriorityTest {

    @DisplayName("Queue에 데이터 입력")
    @Test
    void testCase1() {
        PriorityQueue<Integer> integers = new PriorityQueue<>(Comparator.reverseOrder());
        integers.add(2);
        integers.add(1);
        integers.add(3);
        System.out.println("integers = " + integers);
    }
}