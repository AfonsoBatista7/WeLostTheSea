package objects;

public class NonItemClass extends ObjectClass implements NonItem {

	private String direction;
	private int property;
	
	public NonItemClass(String type, String direction, String description, int property) {
		super(type, description);
		this.direction = direction;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public int getObjectProperty() {
		return property;
	}
}
