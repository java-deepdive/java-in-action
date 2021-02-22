package kr.seok.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomTreeMapTest {

    @Test
    @DisplayName("내장 Tree 테스트")
    void testCase1() {
        CustomTreeMap treeMap = new CustomTreeMap();
        treeMap.put(1, 1);
        treeMap.put(2, 2);
        treeMap.put(3, 3);

        int o = (int) treeMap.get(1);

        assertThat(o).isEqualTo(1);
        assertThat(treeMap.containsKey(3)).isTrue();

        assertThat(treeMap.size()).isEqualTo(3);
        assertThat(treeMap.getFirstEntry().getKey()).isEqualTo(1);
        assertThat(treeMap.getLastEntry().getKey()).isEqualTo(3);

        treeMap.put(4, 4);
    }
}
