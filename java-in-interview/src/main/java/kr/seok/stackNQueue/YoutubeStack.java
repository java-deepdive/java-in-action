package kr.seok.stackNQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class YoutubeStack {

    // 스택 정렬, asc
    static class SortStack {
        static void sort(Stack<Integer> s1) {
            Stack<Integer> s2 = new Stack<>();
            while (!s1.isEmpty()) { // 비어있지 않은 경우 반복
                int tmp = s1.pop();

                while (!s2.isEmpty() && s2.peek() > tmp) { // s2의 top에 있는 값이 tmp 보다 큰 경우 s1 스택에 넣는다.
                    s1.push(s2.pop());
                }
                s2.push(tmp);
            }
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }

    /*
        분석 해야 함
     */
    static class SetOfStacks {
        int capacity;
        ArrayList<Stack<Integer>> stacks = new ArrayList<>();

        SetOfStacks(int capacity) {
            this.capacity = capacity;
        }

        // 마지막 스택을 조회하기 위한 메서드
        public Stack<Integer> getLastStack() {
            if (stacks.size() == 0) return null;
            return stacks.get(stacks.size() - 1);
        }

        // 스택을 추가한다는 말은 ArrayList에 새로운 스택을 추가한다는 말과 같다.
        public void addStack() {
            stacks.add(new Stack<>());
        }

        // ArrayList의 마지막에 존재하는 스택을 삭제
        public void removeLastStack() {
            stacks.remove(stacks.size() - 1);
        }

        //
        public void push(int data) {
            Stack<Integer> last = getLastStack();
            if (last == null || last.size() == capacity) {
                addStack();
                last = getLastStack();
            }
            last.push(data);
        }

        public int pop() {

            Stack<Integer> last = getLastStack();
            if (last == null || last.isEmpty()) throw new EmptyStackException();

            int data = last.pop();

            // pop하고 난 뒤 stack이 비어 있으면 arrayList 삭제
            if (last.isEmpty()) removeLastStack();

            return data;
        }
    }

    /*
        Stack을 이용한 최소 값 찾기 알고리즘

        메인 Stack과 입력마다 값을 비교하여 최소 값을 저장하는 스택을 생성하여 관리하는 방식
     */
    static class MinTwoStack extends Stack<Integer> {

        Stack<Integer> stack;

        public MinTwoStack() {
            this.stack = new Stack<>();
        }

        public int min() {
            if (stack.isEmpty()) return Integer.MAX_VALUE;
            else return stack.peek();
        }

        public void push(int value) {
            if (value < min()) {
                stack.push(value);
            }
            super.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == min()) {
                stack.pop();
            }
            return value;
        }
    }

    static class MinStack extends Stack<MinStack.MinNode> {
        public int min() {
            if (this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().min;
            }
        }

        public void push(int value) {
            int newMin = Math.min(value, min());
            System.out.println("현재 값: " + value + " :: 최소값: " + newMin);
            super.push(new MinNode(value, newMin));
        }

        static class MinNode {
            int value;
            int min;

            public MinNode(int value, int min) {
                this.value = value;
                this.min = min;
            }
        }
    }

    static class LinkedListBasedStack<T> {

        private Node<T> top;

        public T pop() {
            if (top == null) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            return item;
        }

        public void push(T item) {
            Node<T> t = new Node<T>(item);
            t.next = top;
            top = t;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        static class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
            }
        }
    }

    // 고정 길이 배열 스택
    static class ArrayBasedStack {

        private int numOfStacks = 3; // 스택의 개수는 3개로 고정
        private int stackSize; // 각 스택에 사이즈 저장
        private int[] values; // 실제 데이터 필드
        private int[] sizes; // 각 스택의 데이터 사이즈를 저장할 공간

        public ArrayBasedStack(int stackSize) {
            this.stackSize = stackSize;
            this.sizes = new int[numOfStacks]; // 각 스택에 데이터 사이즈를 저장
            this.values = new int[numOfStacks * stackSize]; // 실제 데이터를 저장할 공간을 생성
        }

        public boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        public boolean isFull(int stackNum) {
            return sizes[stackNum] == stackSize;
        }

        public int getTopIndex(int stackNum) {
            int offset = stackSize * stackNum;
            int size = sizes[stackNum];

            return offset + size - 1;
        }

        public void push(int stackNum, int data) {
            if (isFull(stackNum)) throw new FullStackException();

            // top 인덱스를 가져와 하나 증가시킨 후, 그 자리에 data를 대입
            values[getTopIndex(stackNum) + 1] = data;
            sizes[stackNum]++;
        }

        public int pop(int stackNum) {
            if (isEmpty(stackNum)) throw new EmptyStackException();

            int top = getTopIndex(stackNum);
            int data = values[top];
            values[top] = 0;
            sizes[stackNum]--;

            return data;
        }

        public int peek(int stackNum) {
            if (isEmpty(stackNum)) throw new EmptyStackException();
            return values[getTopIndex(stackNum)];
        }

        static class FullStackException extends RuntimeException {
            public FullStackException() {
            }

            public FullStackException(String message) {
                super(message);
            }
        }
    }

}
