package objects.nonItems;

/**
 * @author Afonso Batista
 *
 */
public class BookShelf extends Shelf {

	private static final String TYPE = "BookShelf";
	
	public BookShelf(String direction, String description) {
		super(TYPE, direction, description);	
	}
	

}
