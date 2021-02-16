package kr.seok.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Stack_155Test {
    @Test
    @DisplayName("Stack of Value / Minimum Pairs")
    void testCase1() {
        Stack_155.CustomStackMinimumPairs s1 = new Stack_155.CustomStackMinimumPairs();

        s1.push(-2);
        s1.push(0);
        s1.push(-3);

        assertThat(s1.getMin()).isEqualTo(-3);
        s1.pop();
        assertThat(s1.top()).isEqualTo(0);
        assertThat(s1.getMin()).isEqualTo(-2);

    }

    @Test
    @DisplayName("Two Stacks")
    void testCase2() {
        Stack_155.CustomStackTwoStacks s2 = new Stack_155.CustomStackTwoStacks();

        s2.push(-2);
        s2.push(0);
        s2.push(-3);

        assertThat(s2.getMin()).isEqualTo(-3);
        s2.pop();
        assertThat(s2.top()).isEqualTo(0);
        assertThat(s2.getMin()).isEqualTo(-2);
    }

    @Test
    @DisplayName("Improved Two Stacks")
    void testCase3() {
        Stack_155.CustomStackImprovedTwoStacks s3 = new Stack_155.CustomStackImprovedTwoStacks();

        s3.push(-2);
        s3.push(0);
        s3.push(-3);

        assertThat(s3.getMin()).isEqualTo(-3);
        s3.pop();
        assertThat(s3.top()).isEqualTo(0);
        assertThat(s3.getMin()).isEqualTo(-2);
    }
}
