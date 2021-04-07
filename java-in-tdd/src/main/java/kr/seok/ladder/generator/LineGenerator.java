package kr.seok.ladder.generator;


import kr.seok.ladder.wrapper.Line;

@FunctionalInterface
public interface LineGenerator {
    Line createLine(final int countOfPerson);
}
