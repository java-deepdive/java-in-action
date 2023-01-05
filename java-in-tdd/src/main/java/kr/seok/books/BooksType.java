package kr.seok.books;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public enum BooksType {
	COMPUTER_SCIENCE(Collections.EMPTY_SET),
	DATABASE(Collections.EMPTY_SET),
	PROGRAMMING(Collections.EMPTY_SET),
	OS_NETWORKING(Collections.EMPTY_SET),
	WEB_DEVELOPMENT(Collections.EMPTY_SET),
	SECURITY(Collections.EMPTY_SET),
	ETC(Collections.EMPTY_SET);
	
	private final Set<Books> books;
	
	BooksType(Set<Books> books) {
		this.books = books;
	}
	
	public static Set<BooksType> types() {
		return Arrays.stream(values())
			.collect(Collectors.toSet());
	}
}
