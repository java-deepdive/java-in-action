package kr.seok.item43;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SupplierTest {

    @DisplayName("문자열 리턴 ")
    @Test
    void testCase1() {
        process(() -> "abc");
    }

    public String process(Supplier<String> s) {
        return s.get();
    }
}
