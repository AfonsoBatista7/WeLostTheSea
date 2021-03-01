package objects.nonItems;

/**
 * @author Afonso Batista
 *
 */
public class BookShelf extends Shelf {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9161573594631337923L;
	
	private static final String TYPE = "BookShelf";
	
	public BookShelf(String direction, String description) {
		super(TYPE, direction, description);	
	}
	

}
