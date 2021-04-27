package kr.seok.stack;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class Stack_155 {
    static class CustomStackMinimumPairs {
        private Stack<int[]> stack = new Stack<>();

        public CustomStackMinimumPairs() {
        }

        public void push(int x) {

            /* If the stack is empty, then the min value
             * must just be the first value we add. */
            if (stack.isEmpty()) { // 비어있으면 입력
                stack.push(new int[]{x, x});
                return;
            }

            int currentMin = stack.peek()[1];
            stack.push(new int[]{x, Math.min(x, currentMin)});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }

    static class CustomStackTwoStacks {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public CustomStackTwoStacks() {
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    static class CustomStackImprovedTwoStacks {

        private Stack<Integer> stack = new Stack<>();
        private Stack<int[]> minStack = new Stack<>();

        public CustomStackImprovedTwoStacks() {
        }

        public void push(int x) {

            // We always put the number onto the main stack.
            stack.push(x);

            // If the min stack is empty, or this number is smaller than
            // the top of the min stack, put it on with a count of 1.
            if (minStack.isEmpty() || x < minStack.peek()[0]) {
                minStack.push(new int[]{x, 1});
            }

            // Else if this number is equal to what's currently at the top
            // of the min stack, then increment the count at the top by 1.
            else if (x == minStack.peek()[0]) {
                minStack.peek()[1]++;
            }
        }

        public void pop() {

            // If the top of min stack is the same as the top of stack
            // then we need to decrement the count at the top by 1.
            if (stack.peek().equals(minStack.peek()[0])) {
                minStack.peek()[1]--;
            }

            // If the count at the top of min stack is now 0, then remove
            // that value as we're done with it.
            if (minStack.peek()[1] == 0) {
                minStack.pop();
            }

            // And like before, pop the top of the main stack.
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek()[0];
        }
    }
}
