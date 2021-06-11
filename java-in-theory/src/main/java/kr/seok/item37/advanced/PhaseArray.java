package kr.seok.item37.advanced;

public enum PhaseArray {
    SOLID, LIQUID,
    GAS, PLASMA;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE,
        SUBLIME, DEPOSIT, IONIZE, DEIONIZE;

        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME, null}, // SOLID
                {FREEZE, null, BOIL, null}, // LIQUID
                {DEPOSIT, CONDENSE, null, IONIZE}, // GAS
                {null, null, DEIONIZE, null} // PLASMA
        };

        public static Transition from(PhaseArray from, PhaseArray to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}
