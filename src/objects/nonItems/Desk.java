package objects.nonItems;
import gameSystem.Propertys;
import objects.*;

public class Desk extends NonItemClass {

	private static final String TYPE = "Desk";
	private static final Propertys PROPERTY = Propertys.PUT;
	
	public Desk(String direction, String description) {
		super(TYPE, direction, description, PROPERTY);	
	}
	

}
