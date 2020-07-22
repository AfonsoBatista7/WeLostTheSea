package objects.nonItems;
import objects.*;

public class Bed extends NonItemClass {

	private static final String TYPE = "Bed";
	
	public Bed(String direction, String description) {
		super(TYPE, direction, description);
	}

}
