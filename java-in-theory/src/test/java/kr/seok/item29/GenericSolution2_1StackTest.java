package kr.seok.item29;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenericSolution2_1StackTest {

    @DisplayName("제네릭 클래스 사용 테스트")
    @Test
    void testCase1() {
        GenericSolution2_1Stack<String> stack = new GenericSolution2_1Stack<>();
        for(String arg : new String[] {}) {
            stack.push(arg);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
