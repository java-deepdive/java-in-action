package kr.seok.bowling.v1.domain;


import kr.seok.bowling.v1.exception.NameConventionException;

import java.util.Objects;

/**
 * The type Name.
 */
public class Name {

	private static final String GUIDE_ERR_NAME_SIZE = "이름 작성시 3글자 입력만 가능합니다.";
	private static final int NAME_CONVENTION = 3;
	private final String value;

	private Name(final String inputUserName) {
		this.value = inputUserName;
	}

	/**
	 * Of name.
	 *
	 * @param inputUserName
	 * 		the input user name
	 * @return the name
	 */
	public static Name of(final String inputUserName) {
		if (inputUserName.isEmpty() || inputUserName.length() != NAME_CONVENTION) {
			throw new NameConventionException(GUIDE_ERR_NAME_SIZE);
		}
		return new Name(inputUserName);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Name)) return false;
		final Name name = (Name) o;
		return Objects.equals(value, name.value);
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
