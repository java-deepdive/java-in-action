package kr.seok.ladder.generator;


import kr.seok.ladder.wrapper.Line;

@FunctionalInterface
public interface LineGenerator {
    /**
     * Create line line.
     *
     * @param countOfPerson the count of person
     * @return the line
     */
    Line createLine(final int countOfPerson);
}
