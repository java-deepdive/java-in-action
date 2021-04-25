package com.example.prototype.dev;

import com.example.prototype.dev.concrete.BackEnd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrototypeDevCacheTest {

    @DisplayName("cache 방식으로 조회 하기")
    @Test
    void testCase1() {
        // given
        BaseDeveloper baseDeveloper = PrototypeDevCache.loadCache(DevType.BACKEND);
        // then
        assertThat(baseDeveloper).isEqualTo(new BackEnd());
    }
}
