package locations.exceptions;

public class ItemNotInLocationException extends RuntimeException{

	/**
	 * That item does not exist in this location.
	 */
	private static final long serialVersionUID = 4506519294755949905L;
	private String itemType;
	public ItemNotInLocationException(String itemType) {
		super();
		this.itemType = itemType;
	}
	
	public String getItemType() { return itemType; }

}
