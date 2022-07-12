package objects.nonItems;
import gameSystem.Propertys;
import objects.*;

/**
 * @author Afonso Batista
 *
 */
public class Chair extends NonItemClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6384316036197636541L;
	
	private static final String TYPE = "Chair";
	private static final Propertys[] PROPERTY = {Propertys.SIT};
	
	public Chair(String direction, String description) {
		super(TYPE, direction, description, PROPERTY);
	}

}