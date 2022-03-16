package kr.seok.ladder.domain;

import java.util.Objects;

/**
 * The type User.
 */
public class User {

	private final Name name;
	private final Position position;

	private User(final String name) {
		this(Name.valueOf(name), Position.valueOf(0));
	}

	private User(final String name, final int position) {
		this(Name.valueOf(name), Position.valueOf(position));
	}

	private User(final Name name, final Position position) {
		this.name = name;
		this.position = position;
	}

	/**
	 * Value of user.
	 *
	 * @param name
	 * 		the name
	 * @return the user
	 */
	public static User valueOf(final String name) {
		return new User(name);
	}

	/**
	 * Value of user.
	 *
	 * @param name
	 * 		the name
	 * @param position
	 * 		the position
	 * @return the user
	 */
	public static User valueOf(final String name, final int position) {
		return new User(name, position);
	}

	/**
	 * Position position.
	 *
	 * @return the position
	 */
	public Position position() {
		return position;
	}

	/**
	 * Match boolean.
	 *
	 * @param user
	 * 		the user
	 * @return the boolean
	 */
	public boolean match(final User user) {
		return name.equals(user.name);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		final User user = (User) o;
		return Objects.equals(name, user.name)
				&& Objects.equals(position, user.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}

	@Override
	public String toString() {
		return String.valueOf(name);
	}
}
