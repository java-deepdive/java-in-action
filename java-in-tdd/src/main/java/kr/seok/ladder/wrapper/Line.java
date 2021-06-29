package kr.seok.ladder.wrapper;


import kr.seok.ladder.domain.Bar;
import kr.seok.ladder.domain.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The type Line.
 */
public class Line {

    private final Bars bars;

    /**
     * Instantiates a new Line.
     *
     * @param bars the bars
     */
    public Line(Bar... bars) {
        this(Arrays.asList(bars));
    }

    /**
     * Instantiates a new Line.
     *
     * @param bars the bars
     */
    public Line(List<Bar> bars) {
        this.bars = Bars.valueOf(bars);
    }

    /**
     * Value of line.
     *
     * @param bars the bars
     * @return the line
     */
    public static Line valueOf(final Bar... bars) {
        return new Line(bars);
    }

    /**
     * Value of line.
     *
     * @param bars the bars
     * @return the line
     */
    public static Line valueOf(final List<Bar> bars) {
        return new Line(bars);
    }

    /**
     * Points bars.
     *
     * @return the bars
     */
    public Bars points() {
        return bars;
    }

    /**
     * Move position.
     *
     * @param userPosition the user position
     * @return the position
     */
    public Position move(final Position userPosition) {
        return bars.move(userPosition);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        final Line line = (Line) o;
        return Objects.equals(bars, line.bars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bars);
    }

    @Override
    public String toString() {
        return String.valueOf(bars);
    }

}
