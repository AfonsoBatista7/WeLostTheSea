package locations.exceptions;

public class ItsAnItemException extends RuntimeException {
	/**
	 * The input object is an item.
	 */
	private static final long serialVersionUID = -4303033917320233693L;
	
	private String itemType;
	public ItsAnItemException(String itemType) {
		super();
		this.itemType = itemType;
	}
	
	public String getItemType() { return itemType; }
	
}
