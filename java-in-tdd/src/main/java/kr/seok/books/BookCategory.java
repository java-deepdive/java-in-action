package kr.seok.books;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public enum BookCategory {
	
	NOVEL(Collections.EMPTY_SET),
	ART(Collections.EMPTY_SET),
	COMPUTER(BooksType.types()),
	EMPTY(Collections.EMPTY_SET);
	
	private final Collection<BooksType> computerType;
	
	BookCategory(Set<BooksType> computerType) {
		this.computerType = computerType;
	}
	
	public static BookCategory of(BooksType bookType) {
		return Arrays.stream(values())
			.filter(bookCategory -> bookCategory.hasBookType(bookType))
			.findAny()
			.orElse(EMPTY);
	}
	
	public Collection<BooksType> getComputerType() {
		return computerType;
	}
	
	private boolean hasBookType(BooksType bookType) {
		return computerType.stream()
			.anyMatch(computerType -> computerType.equals(bookType));
	}
}
