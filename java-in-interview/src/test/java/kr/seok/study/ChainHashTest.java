package kr.seok.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChainHashTest {
    ChainHash<Integer, Data> chainHash;
    Data data;

    @BeforeEach
    public void setUp() {
        chainHash = new ChainHash<>(1);
    }

    @Test
    @DisplayName("Hash 확인")
    void testCase1() {
        // 기본 용량이 11
        chainHash.dump();
    }

    // 00 → 323232 (Data{key=3, value='data3'}) → 2 (Data{key=1, value='data1'}) → 1 (Data{key=1, value='data1'})
    @Test
    @DisplayName("add() 데이터 추가")
    void testCase2() {
        Data data1 = new Data(1, "data1");
        Data data2 = new Data(2, "data2");
        Data data3 = new Data(3, "data3");

        chainHash.add(1, data1);
        chainHash.add(2, data2);
        chainHash.add(323232, data3);

        chainHash.dump();
    }

    @Test
    @DisplayName("search() 테스트")
    void testCase3() {
        Data data1 = new Data(1, "data1");
        Data data2 = new Data(2, "data2");

        chainHash.add(1, data1);
        chainHash.add(2, data2);

        Data findData = chainHash.search(1);
        assertThat(findData.getValue()).isEqualTo("data1");

        Data findData2 = chainHash.search(2);
        assertThat(findData2.getValue()).isEqualTo("data2");

        chainHash.dump();
    }

    @Test
    @DisplayName("remove() 테스트")
    void testCase4() {
        Data data1 = new Data(1, "data1");
        Data data2 = new Data(2, "data2");

        chainHash.add(1, data1);
        chainHash.add(2, data2);

        int removed1 = chainHash.remove(1);
        assertThat(removed1).isEqualTo(0);

        int removed2 = chainHash.remove(2);
        assertThat(removed2).isEqualTo(0);

        int removed3 = chainHash.remove(3);
        assertThat(removed3).isEqualTo(1); // 해당 키 값은 존재하지 않음
    }

    static class Data {
        private int key;
        private String value;

        public Data(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
