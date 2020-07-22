package objects;

public class ItemClass extends ObjectClass implements Item {

	private String name;
	
	public ItemClass(String type, String description) {
		super(type, description);
		name = type;
	}
	
	public String getItemName() {
		return name;
	}
	
	public void setItemName(String name) {
		this.name = name;
	}
	
}
