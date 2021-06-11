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

        private final PhaseEnumMap from;
        private final PhaseEnumMap to;

        Transition(PhaseEnumMap from, PhaseEnumMap to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<PhaseEnumMap, Map<PhaseEnumMap, Transition>> m =
                Stream.of(values()) // enum 타입 두 개를 매핑한 필드 리스트
                        .collect(
                                groupingBy(
                                        t -> t.from, //
                                        () -> new EnumMap<>(PhaseEnumMap.class),
                                        toMap(
                                                t -> t.to,
                                                t -> t,
                                                (x, y) -> y,
                                                () -> new EnumMap<>(PhaseEnumMap.class)
                                        ))
                        );

        public static Transition from(PhaseEnumMap from, PhaseEnumMap to) {
            return m.get(from).get(to);
        }
    }
}
