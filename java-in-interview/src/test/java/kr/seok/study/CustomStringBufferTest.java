package kr.seok.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomStringBufferTest {

    CustomStringBuffer sb;

    @BeforeEach
    public void setUp() {
        sb = new CustomStringBuffer("This is");
    }

    @Test
    @DisplayName("Constructor 테스트")
    void testCase1() {
        assertThat(sb.toString()).contains("This is");
    }

    @Test
    @DisplayName("append 메서드 테스트")
    void testCase2() {
        int originHashCode = System.identityHashCode(sb);
        System.out.println(originHashCode + " :: " + sb.toString());
        sb.append(" Constructor Test");
        System.out.println(System.identityHashCode(sb) + " :: " + sb.toString());

        assertThat(sb.toString()).contains("This is Constructor Test");
        assertThat(originHashCode).isEqualTo(System.identityHashCode(sb));
    }

    @Test
    @DisplayName("insert 메서드 테스트")
    void testCase3() {
        int length = sb.length();
        sb.insert(length, " insert Method");
        System.out.println(sb.toString());
        assertThat(sb.toString()).contains("This is");
    }

    @Test
    @DisplayName("delete 메서드 테스트")
    void testCase4() {
        sb.delete(4, 7);
        System.out.println(sb.toString());
        assertThat(sb.length()).isEqualTo(4);
    }

    @Test
    @DisplayName("replace 메서드 테스트")
    void testCase5() {
        sb.replace(4, 5, " is Good ");
        System.out.println(sb.toString());
        assertThat(sb.toString()).contains("This is Good is");
    }

    @Test
    @DisplayName("StringBuffer replace 테스트")
    void testCase6() {
        StringBuffer stringBuffer = new StringBuffer("This is");
        stringBuffer.replace(4, 5, " is Good");
        System.out.println(stringBuffer.toString());
    }

    @Test
    @DisplayName("StringBuffer reverse 테스트")
    void testCase7() {
        sb.reverse();
        assertThat(sb.toString()).contains("si sihT");
    }
}
