package objects;

public class NonItemClass extends ObjectClass implements NonItem {

	private String direction;
	
	public NonItemClass(String type, String direction, String description) {
		super(type, description);
		this.direction = direction;
	}
	
	public String getDirection() {
		return direction;
	}

}
