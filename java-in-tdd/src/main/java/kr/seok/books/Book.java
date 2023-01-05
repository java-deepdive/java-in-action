package kr.seok.books;

public class Book {
	private final String title;
	private final String author;
	private final BooksType category;
	
	public Book(String title, String author, BooksType category) {
		this.title = title;
		this.author = author;
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public BooksType getCategory() {
		return category;
	}
}
