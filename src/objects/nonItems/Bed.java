package objects.nonItems;
import gameSystem.Propertys;
import objects.*;

/**
 * @author Afonso Batista
 *
 */
public class Bed extends NonItemClass {

	private static final String TYPE = "Bed";
	private static final Propertys PROPERTY = Propertys.LAY;
	
	public Bed(String direction, String description) {
		super(TYPE, direction, description, PROPERTY);
	}

}
