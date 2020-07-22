package objects;

public class nonItemClass extends ObjectClass implements nonItem {

	private String direction;
	
	public nonItemClass(String type, String direction, String description) {
		super(type, description);
		this.direction = direction;
	}
	
	public String getDirection() {
		return direction;
	}

}
