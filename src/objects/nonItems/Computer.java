package objects.nonItems;
import gameSystem.Propertys;
import objects.*;

/**
 * @author Afonso Batista
 *
 */
public class Computer extends NonItemClass {

	private static final String TYPE = "Computer";
	private static final Propertys PROPERTY = Propertys.USE;
	
	public Computer(String direction, String description) {
		super(TYPE, direction, description, PROPERTY);
	}

}
