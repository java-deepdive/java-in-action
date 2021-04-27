package kr.seok.stackNQueue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

class YoutubeStackTest {

    @Test
    @DisplayName("스택 메서드 확인 테스트")
    void testCase1() {
        YoutubeStack.ArrayBasedStack arrStack = new YoutubeStack.ArrayBasedStack(5);

        try {
            arrStack.push(0, 1);
            arrStack.push(0, 2);
            arrStack.push(0, 3);
            arrStack.push(0, 4);
            arrStack.push(0, 5);

            arrStack.push(1, 11);
            arrStack.push(1, 12);
            arrStack.push(1, 13);
            arrStack.push(1, 14);
            arrStack.push(1, 15);

        } catch (YoutubeStack.ArrayBasedStack.FullStackException e) {
            System.out.println("Exception :: " + e);
        }

        try {
            System.out.println("stack : #0 " + arrStack.pop(0));
            System.out.println("stack : #0 " + arrStack.pop(0));
            System.out.println("stack : #0 " + arrStack.peek(0));
            System.out.println("stack : #0 " + arrStack.pop(0));
            System.out.println("stack : #0 " + arrStack.isEmpty(0));
            System.out.println("stack : #0 " + arrStack.pop(0));
            System.out.println("stack : #0 " + arrStack.pop(0));
            System.out.println("stack : #0 " + arrStack.isEmpty(0));

            System.out.println("stack : #1 " + arrStack.pop(1));
            System.out.println("stack : #1 " + arrStack.pop(1));
            System.out.println("stack : #1 " + arrStack.peek(1));
            System.out.println("stack : #1 " + arrStack.pop(1));
            System.out.println("stack : #1 " + arrStack.isEmpty(1));
            System.out.println("stack : #1 " + arrStack.pop(1));
            System.out.println("stack : #1 " + arrStack.pop(1));
            System.out.println("stack : #1 " + arrStack.isEmpty(1));

        } catch (EmptyStackException e) {
            System.out.println("isEmpty");
        }
    }

    @Test
    @DisplayName("최소 값 반환하기")
    void testCase2() {
        YoutubeStack.MinStack minStack = new YoutubeStack.MinStack();

        minStack.push(3);
        minStack.push(5);
        minStack.push(1);
        minStack.push(2);

        System.out.println("min : " + minStack.min());
        System.out.println(minStack.pop().value);
        System.out.println(minStack.pop().value);
        System.out.println("min : " + minStack.min());
    }
}
