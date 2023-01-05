package kr.seok.books;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BookCategoryTest {
	
	@Test
	void testCase1() {
		// given
		Book books = new Book("Effective Java", "Joshua Bloch", BooksType.COMPUTER_SCIENCE);
		// when
		BookCategory actual = BookCategory.of(books.getCategory());
		// then
		assertThat(actual).isEqualTo(BookCategory.COMPUTER);
	}
}