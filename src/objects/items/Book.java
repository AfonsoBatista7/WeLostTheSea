package objects.items;

import objects.ItemClass;

public class Book extends ItemClass {

	private static final String TYPE = "Book",
								DESCRIPTION = "An item that you can read. When it's read, shares the knowledge it has with the reader.\n"
										    + " (Sometimes there are some hidden tips that can help a lost adventurer)";
	private String bookTitle, text;
	
	public Book() {
		super(TYPE, DESCRIPTION);
		bookTitle="";
		text="";
	}
	
	public Book(String bookTitle, String text) {
		super(TYPE, DESCRIPTION, bookTitle);
		this.bookTitle = bookTitle;
		this.text = text;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public String readBook() {
		return text;
	}
	
	/**
	 * Writes a new book.
	 * @param bookTitle - Book title.
	 * @param text - Text on the Book.
	 */
	public void writeBook(String bookTitle, String text) {
		this.bookTitle = bookTitle;
		this.text = text;
	}
}
