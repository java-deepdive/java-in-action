package kr.seok.item89;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.seok.item89.Util.deserialize;

class ElvisImpersonatorTest {

    @DisplayName("역직렬화 인스턴스 하나 -> impersonator 초기화된 인스턴스 하나 서로 다른 인스턴스")
    @Test
    void testCase1() {

        byte[] serialize = Util.serialize(Elvis.INSTANCE);

        Elvis elvis = (Elvis) deserialize(serialize);
        // impersonator 초기화
        Elvis impersonator = ElvisStealer.impersonator;

        elvis.printFavorites();
        impersonator.printFavorites();
    }
}
