package kr.seok.kakao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCompressTest {

    @DisplayName("문자열 압축 테스트1")
    @Test
    void testCase1() {
        StringCompress compress = new StringCompress();

        int actual = compress.solution("aabbaccc");

        assertThat(actual).isEqualTo(7);
    }
}
