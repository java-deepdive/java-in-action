package kr.seok.bowling.v1.domain.state;

import kr.seok.bowling.v1.domain.engine.State;
import kr.seok.bowling.v1.domain.state.finish.Spare;
import kr.seok.bowling.v1.domain.state.finish.Strike;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The type States.
 */
public class States {

	private final List<State> status;

	/**
	 * Instantiates a new States.
	 */
	public States() {
		this.status = new LinkedList<>();
	}

	/**
	 * Add.
	 *
	 * @param state
	 * 		the state
	 */
	public void add(State state) {
		status.add(state);
	}

	/**
	 * Is bonus state boolean.
	 *
	 * @return the boolean
	 */
	public boolean isBonusState() {
		return status.stream()
				.noneMatch(s -> isState(s, Strike.class) || isState(s, Spare.class));
	}

	private boolean isState(final State state, Class<?> classType) {
		return state.getClass().isAssignableFrom(classType);
	}

	/**
	 * Values list.
	 *
	 * @return the list
	 */
	public List<State> values() {
		return Collections.unmodifiableList(status);
	}
}
