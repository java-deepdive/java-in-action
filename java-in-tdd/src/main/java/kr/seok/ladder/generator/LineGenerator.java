package kr.seok.ladder.generator;


import kr.seok.ladder.wrapper.Line;


/**
 * {@inheritDoc The interface Line generator.}
 */
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
