package kr.seok.item37;

import org.apache.commons.compress.utils.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {

    private List<Plant> garden;

    @BeforeEach
    void setUp() {
        garden = Arrays.asList(
                new Plant("ANNUAL_TREE_1", Plant.LifeCycle.ANNUAL),
                new Plant("ANNUAL_TREE_2", Plant.LifeCycle.ANNUAL),
                new Plant("ANNUAL_TREE_3", Plant.LifeCycle.ANNUAL),
                new Plant("BIENNIAL_TREE_1", Plant.LifeCycle.BIENNIAL)
//                new Plant("PERENNIAL_TREE_1", Plant.LifeCycle.PERENNIAL)
        );
    }

    @DisplayName("Set과 배열을 이용해 정원에 있는 식물 등록하기")
    @Test
    void testCase1() {
        // given
        Client client = new Client();

        // then
        client.addPlant(garden);
    }

    @DisplayName("EmumMap을 이용해 정원의 식물 등록하기")
    @Test
    void testCase2() {
        Client client = new Client();

        // then
        client.addPlantTypeEnumMap(garden);
    }

    // {ANNUAL=[ANNUAL_TREE_1, ANNUAL_TREE_2, ANNUAL_TREE_3], BIENNIAL=[BIENNIAL_TREE_1], PERENNIAL=[PERENNIAL_TREE_1]}
    @DisplayName("EnumMap을 사용하지 않고 Collections.grouping 테스트")
    @Test
    void testCase3() {
        Map<Plant.LifeCycle, List<Plant>> garden =
                this.garden.stream().collect(groupingBy(p -> p.lifeCycle));

        List<Plant> excepted = Arrays.asList(
                new Plant("ANNUAL_TREE_1", Plant.LifeCycle.ANNUAL),
                new Plant("ANNUAL_TREE_2", Plant.LifeCycle.ANNUAL),
                new Plant("ANNUAL_TREE_3", Plant.LifeCycle.ANNUAL)
        );

        System.out.println(garden);
        assertThat(garden).containsEntry(Plant.LifeCycle.ANNUAL, excepted);
    }

    // {ANNUAL=[ANNUAL_TREE_1, ANNUAL_TREE_2, ANNUAL_TREE_3], BIENNIAL=[BIENNIAL_TREE_1]}
    @DisplayName("EnumMap을 이용해 데이터와 열거 타입을 매핑하는 테스트")
    @Test
    void testCase4() {
        Map<Plant.LifeCycle, Set<Plant>> garden = this.garden.stream()
                .collect(
                        groupingBy(
                                p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), toSet()
                        ));

        Set<Plant> excepted = Sets.newHashSet(
                new Plant("ANNUAL_TREE_1", Plant.LifeCycle.ANNUAL),
                new Plant("ANNUAL_TREE_2", Plant.LifeCycle.ANNUAL),
                new Plant("ANNUAL_TREE_3", Plant.LifeCycle.ANNUAL)
        );

        assertThat(garden).containsEntry(Plant.LifeCycle.ANNUAL, excepted);
    }
}
