package objects.items;

import objects.ItemClass;

/**
 * Book.
 * @author Afonso Batista
 */
public class Book extends ItemClass {

	private static final String TYPE = "Book",
								DESCRIPTION = "An item that you can read. When it's read, shares the knowledge it has with the reader.\n"
										    + " (Sometimes there are some hidden tips that can help a lost adventurer)";
	private static final double PRICE = 5.0; 
			
	private String bookTitle, text;
	
	public Book() {
		super(TYPE, DESCRIPTION, PRICE);
		bookTitle="";
		text="";
	}
	
	public Book(String bookTitle, String text) {
		super(TYPE, DESCRIPTION, PRICE, bookTitle);
		this.bookTitle = bookTitle;
		this.text = text;
	}
	
	/**
	 * @return book title.
	 */
	public String getBookTitle() {
		return bookTitle;
	}
	
	/**
	 * @return book text.
	 */
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
