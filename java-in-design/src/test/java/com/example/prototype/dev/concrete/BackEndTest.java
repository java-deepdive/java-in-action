package com.example.prototype.dev.concrete;

import com.example.prototype.dev.BaseDeveloper;
import com.example.prototype.dev.DevType;
import com.example.prototype.dev.PrototypeDevCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BackEndTest {

    // dev -> frontend

    // cache(Map) -> loadCache() (clone 된 객체)
    @DisplayName("프론트엔드 클론 생성 테스트")
    @Test
    void testCase() {
        // when
        BaseDeveloper baseDeveloper = PrototypeDevCache.loadCache(DevType.FRONTEND);
        // then
        assertThat(baseDeveloper).isEqualTo(new FrontEnd());
    }
}
