package kr.seok.stackNQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomStackTest {

    public CustomStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new CustomStack<>();
    }

    @DisplayName(value = "스택 생성 및 push 테스트")
    @Test
    void testCase() {
        assertThat(stack.empty()).isTrue();
    }

    @DisplayName(value = "스택 생성 및 push 테스트")
    @Test
    void testCase1() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThat(stack.size()).isEqualTo(4);
    }

    @DisplayName(value = "스택 push & peek 테스트")
    @Test
    void testCase2() {
        stack.push(1);
        stack.push(3);

        Integer peek = stack.peek();
        assertThat(peek).isEqualTo(3);
    }

    @DisplayName(value = "스택 push & pop 테스트")
    @Test
    void testCase3() {
        stack.push(1);
        stack.push(5);
        stack.push(7);

        Integer pop = stack.pop();

        assertThat(pop).isEqualTo(7);
    }

    @DisplayName(value = "스택 search 테스트")
    @Test
    void testCase4() {
        // given
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(6);
        // when
        int search = stack.search(3);
        // then
        assertThat(search).isEqualTo(2);
    }
}
