package kr.seok.string;

import kr.seok.stack.String_20;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class String_20Test {

    String_20 s20;

    @BeforeEach
    public void setUp() {
        s20 = new String_20();
    }
    @Test
    void testCase1() {
        boolean valid = s20.isValid("[{{}}]");
        assertThat(valid).isTrue();
    }
}
