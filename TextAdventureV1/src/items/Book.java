package items;

public class Book extends ItemClass {
	
	private String content;
	
	public Book(int quantity, String content) {
		super("Book", quantity);
	}
	
	public String getContent() {
		return content;
	}

}
