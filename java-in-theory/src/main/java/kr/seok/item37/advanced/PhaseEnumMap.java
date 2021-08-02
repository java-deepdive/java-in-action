package kr.seok.item37.advanced;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public enum PhaseEnumMap {
    SOLID, LIQUID, GAS, PLASMA;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
        IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);

        private static final Map<PhaseEnumMap, Map<PhaseEnumMap, Transition>> m =
                Stream.of(values()) // enum 타입 두 개를 매핑한 필드 리스트
                        .collect(groupingBy(
                                t -> t.from, // Phase 타입을 Key 값으로 정의
                                () -> new EnumMap<>(PhaseEnumMap.class), // Value를 Map 타입으로 정의
                                toMap(
                                        t -> t.to,
                                        t -> t,
                                        (x, y) -> y,
                                        () -> new EnumMap<>(PhaseEnumMap.class)
                                )));
        private final PhaseEnumMap from;
        private final PhaseEnumMap to;

        Transition(PhaseEnumMap from, PhaseEnumMap to) {
            this.from = from;
            this.to = to;
        }

        public static Transition from(PhaseEnumMap from, PhaseEnumMap to) {
            return m.get(from).get(to);
        }
    }
}
