package org.afonsobatista.objects;

public class ItemClass extends ObjectClass implements Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4691512550620509919L;
	
	private String name;
	private double price;
	
	public ItemClass(String type, String description) {
		super(type, description);
		name = type;
	}
	
	public ItemClass(String type, String description, double price) {
		super(type, description);
		this.price = price;
		name = type;
	}
	
	public ItemClass(String type, String description, double price, String name) {
		super(type, description);
		this.name = name;
		this.price = price;
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
