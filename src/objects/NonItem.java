package objects;

import gameSystem.Propertys;

public interface NonItem extends Object {

	/**
	 * @return the specific location of the object inside the location.
	 */
	String getDirection();
	
	Propertys getObjectProperty();
}
