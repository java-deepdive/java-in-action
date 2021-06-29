package kr.seok.ladder.controller;

import java.util.function.Supplier;

/**
 * The type Ladder parameter helper.
 */
public final class LadderParameterHelper {
    private LadderParameterHelper() {
    }

    /**
     * Parse argument resolver t.
     *
     * @param <T>    메서드 결과 값을 반환하는 타입
     * @param method the method
     * @return 특정 타입 또는 배열을 반환
     */
    public static <T> T parseArgumentResolver(final Supplier<T> method) {
        try {
            return method.get();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }
}
