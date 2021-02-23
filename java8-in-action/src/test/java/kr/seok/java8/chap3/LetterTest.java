package kr.seok.java8.chap3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

class LetterTest {
    Function<String, String> addHeader = Letter::addHeader;
    Function<String, String> transformationPipeline = addHeader
            .andThen(Letter::checkSpelling)
            .andThen(Letter::addFooter);

    Function<String, String> transformationPipelineExceptCheckSpelling =
            addHeader.andThen(Letter::addFooter);

    @Test
    @DisplayName(" 파이프 라인을 만들기 위한 테스트 ")
    void testCase1() {
        String totalLetter = transformationPipeline.apply("Seok");
        System.out.println(totalLetter);
    }

    @Test
    @DisplayName("파이프 라인 조합하기")
    void testCase2() {
        String totalLetter = transformationPipelineExceptCheckSpelling.apply("seok");
        System.out.println(totalLetter);
    }
}
