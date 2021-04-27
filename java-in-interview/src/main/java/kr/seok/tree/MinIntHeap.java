package kr.seok.tree;

import java.util.Arrays;

public class MinIntHeap {

    private int capacity = 10;
    private int size = 0;

    public int getSize() {
        return size;
    }

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int idx1, int idx2) {
        int tmp = items[idx1];
        items[idx1] = items[idx2];
        items[idx2] = tmp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        items[size - 1] = 0;
        size--;

        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;

        heapifyUp();
    }

    private void heapifyDown() {
        int index = 0; // parent 노드의 인덱스 부터 시작
//        System.out.println("index : " + index + " :: " + hasLeftChild(index));
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            System.out.println("smallerChildIndex :: " + smallerChildIndex);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) { // 자식 노드와 부모노드(현재 노드)의 대소 비교
                break; // 부모 노드 가 더 작은 경우 (힙 성질에 부합함)
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex; // 점차 하위 노드로 진행
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
//            System.out.println(index);
        }
    }
}
