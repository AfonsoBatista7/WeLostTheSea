package entety.exceptions;

public class ItemNotInBagException extends RuntimeException {

	
	/**
	 * Item does not exist in bag.
	 */
	private static final long serialVersionUID = 5109837651762448249L;
	private String itemType;
	
	public ItemNotInBagException(String itemType) {
		super();
		this.itemType = itemType;
	}
	
	public String getItemType() { return itemType; }
	
}
