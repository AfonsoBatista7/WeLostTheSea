package objects.nonItems;
import objects.*;

public class Shelf extends NonItemClass {

	private static final String TYPE = "Shelf";
	
	public Shelf(String direction, String description) {
		super(TYPE, direction, description);	
	}
	
	public Shelf(String type, String direction, String description) {
		super(type, direction, description);	
	}
	

}
