package kr.seok.ladder.wrapper;


import kr.seok.ladder.domain.User;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type Participants.
 */
public class Participants {

	private final Set<User> users;

	private Participants(final String... users) {
		this.users = parseUsers(users);
	}

	/**
	 * Value of participants.
	 *
	 * @param users
	 * 		the users
	 * @return the participants
	 */
	public static Participants valueOf(final String... users) {
		return new Participants(users);
	}

	private Set<User> parseUsers(final String... users) {
		return IntStream.range(0, users.length)
				.mapToObj(value -> User.valueOf(users[value], value))
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	/**
	 * Size int.
	 *
	 * @return the int
	 */
	public int size() {
		return users.size();
	}

	/**
	 * Gets users.
	 *
	 * @return the users
	 */
	public Set<User> getUsers() {
		return Collections.unmodifiableSet(users);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Participants)) return false;
		final Participants that = (Participants) o;
		return Objects.equals(users, that.users);
	}

	@Override
	public int hashCode() {
		return Objects.hash(users);
	}

	@Override
	public String toString() {
		return String.valueOf(users);
	}
}
