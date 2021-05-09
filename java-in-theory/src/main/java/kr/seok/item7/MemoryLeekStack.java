package kr.seok.item7;

public class MemoryLeekStack {
    private int maxSize;
    private int[] stackArray;
    private int pointer;

    public MemoryLeekStack(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        pointer = -1;
    }

    public void push(int j) {
        stackArray[++pointer] = j;
    }

    public int pop() {
        int size = pointer--;
        int element= stackArray[size];
        return element;
    }

    public int peek() {
        return stackArray[pointer];
    }

    public boolean isEmpty() {
        return (pointer == -1);
    }

    public boolean isFull() {
        return (pointer == maxSize - 1);
    }

}
