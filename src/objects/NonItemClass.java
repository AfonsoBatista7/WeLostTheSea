package objects;

import gameSystem.Propertys;

public class NonItemClass extends ObjectClass implements NonItem {
	
	private String direction;
	private Propertys property;
	
	public NonItemClass(String type, String direction, String description, Propertys property) {
		super(type, description);
		this.direction = direction;
		this.property = property;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public Propertys getObjectProperty() {
		return property;
	}
}
