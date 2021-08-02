package kr.seok.item89;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class Elvis_3Test {

    @DisplayName("잘못된 싱글턴 케이스")
    @Test
    void testCase1() throws IOException, ClassNotFoundException {
        // given
        Elvis_3 instance = Elvis_3.INSTANCE;

        // when
        byte[] serialized = serialize(instance);
        Elvis_3 deserializedElvis = (Elvis_3) deserialize(serialized);
        System.out.printf("old : %s , new : %s%n", instance, deserializedElvis);

        // then
        assertThat(instance).isEqualTo(deserializedElvis);
    }

    private Object deserialize(byte[] serializedData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
        try (ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        }
    }

    private byte[] serialize(Object instance) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 직렬화
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(instance);
        }
        return bos.toByteArray();
    }

}
