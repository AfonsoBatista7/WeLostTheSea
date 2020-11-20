package objects;

public class ItemClass extends ObjectClass implements Item {

	private String name;
	private double price;
	
	public ItemClass(String type, String description, double price) {
		super(type, description);
		name = type;
		this.price = price;
	}
	
	public ItemClass(String type, String description, String name) {
		super(type, description);
		this.name = name;
	}
	
	public String getItemName() {
		return name;
	}
	
	public void setItemName(String name) {
		this.name = name;
	}
	
	public double getItemPrice() {
		return price;
	}
	
}
