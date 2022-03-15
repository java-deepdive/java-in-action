package kr.seok.queue;

import java.util.PriorityQueue;

public class Priority {
    private final PriorityQueue<Integer> priorityQueue;

    public Priority(PriorityQueue<Integer> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    public void add(int param) {
        priorityQueue.add(param);
    }

    public void print() {
        priorityQueue.forEach(integer -> System.out.println("integer = " + integer));
    }
}
