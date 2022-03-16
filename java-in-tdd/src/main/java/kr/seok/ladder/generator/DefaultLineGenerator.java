package kr.seok.ladder.generator;


import kr.seok.ladder.domain.Bar;
import kr.seok.ladder.wrapper.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * The type Default line generator.
 */
public class DefaultLineGenerator implements LineGenerator {

	private static final Random RANDOM = new Random();

	@Override
	public Line createLine(final int countOfPerson) {

		List<Bar> bars = new ArrayList<>(Arrays.asList(Bar.init()));
		IntStream.range(bars.size(), countOfPerson)
				.forEach(value -> addNextPoint(bars, value));

		return Line.valueOf(bars);
	}

	private void addNextPoint(final List<Bar> bars, final int value) {
		Bar bar = bars.get(value - 1);
		bars.add(point(bar.isExist()));
	}

	private Bar point(final boolean point) {
		if (point) {
			return Bar.init();
		}
		return Bar.valueOf(RANDOM.nextBoolean());
	}
}
