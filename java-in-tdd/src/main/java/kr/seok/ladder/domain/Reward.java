package kr.seok.ladder.domain;

import java.util.Objects;

/**
 * The type Reward.
 */
public class Reward {

	/**
	 * The constant GUIDE_ERR_REWARD_EMPTY.
	 */
	public static final String GUIDE_ERR_REWARD_EMPTY = "값이 존재하지 않습니다.";
	private final String value;

	private Reward(final String value) {
		this.value = value;
	}

	/**
	 * Value of reward.
	 *
	 * @param reward
	 * 		the reward
	 * @return the reward
	 */
	public static Reward valueOf(final String reward) {
		if (isNullOrEmpty(reward)) {
			throw new IllegalArgumentException(GUIDE_ERR_REWARD_EMPTY);
		}
		return new Reward(reward);
	}

	private static boolean isNullOrEmpty(final String reward) {
		return Objects.isNull(reward) || reward.isEmpty();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Reward)) return false;
		final Reward reward = (Reward) o;
		return Objects.equals(value, reward.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
