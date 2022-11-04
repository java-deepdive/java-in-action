package kr.seok.item7.memoryleek;

public class Stack {
	private final int maxSize;
	private final int[] stackArray;
	private int pointer;
	
	public Stack(int s) {
		maxSize = s;
		stackArray = new int[maxSize];
		pointer = -1;
	}
	
	public void push(int j) {
		stackArray[++pointer] = j;
	}
	
	public int pop() {
		int size = pointer--;
		int element = stackArray[size];
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
