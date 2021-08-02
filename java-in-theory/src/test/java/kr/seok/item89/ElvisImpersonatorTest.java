package kr.seok.item89;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

class ElvisImpersonatorTest {

    @DisplayName("역직렬화 인스턴스 하나 -> impersonator 초기화된 인스턴스 하나 서로 다른 인스턴스")
    @Test
    void testCase1() throws IOException, ClassNotFoundException {

        Elvis elvis = (Elvis) deserialize(ElvisImpersonator.serializedForm);
        // impersonator 초기화
        Elvis impersonator = ElvisStealer.impersonator;

        elvis.printFavorites();
        impersonator.printFavorites();
    }

    private Object deserialize(byte[] serializedData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
        try (ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        }
    }
}
