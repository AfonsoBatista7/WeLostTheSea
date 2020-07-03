package locations.exceptions;

public class NotAnItemException extends RuntimeException {

	/**
	 * The input object is not an item.
	 */
	private static final long serialVersionUID = -3755609054818536014L;
	private String itemType;
	public NotAnItemException(String itemType) {
		super();
		this.itemType = itemType;
	}
	
	public String getItemType() { return itemType; }
	
}
