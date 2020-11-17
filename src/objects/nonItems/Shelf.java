package objects.nonItems;
import gameSystem.Propertys;
import objects.*;

/**
 * @author Afonso Batista
 *
 */
public class Shelf extends NonItemClass {

	private static final String TYPE = "Shelf";
	private static final Propertys PROPERTY = Propertys.PUT;
	
	public Shelf(String direction, String description) {
		super(TYPE, direction, description, PROPERTY);	
	}
	
	public Shelf(String type, String direction, String description) {
		super(type, direction, description, PROPERTY);	
	}
	

}
