package objects;

import entety.Entety;
import gameSystem.Propertys;

public interface NonItem extends Object {

	/**
	 * @return the specific location of the object inside the location.
	 */
	String getDirection();
	
	Propertys getObjectProperty();
	
	Entety getUser();
	
	boolean isAvailable();
	
	void objectOccupied(Entety user);
}
