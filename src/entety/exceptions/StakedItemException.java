package entety.exceptions;

public class StakedItemException extends RuntimeException {

	/**
	 * The item is staked.
	 */
	private static final long serialVersionUID = 3347352656319357987L;
	private String itemType;
	public StakedItemException(String itemType) {
		super();
		this.itemType = itemType;
	}
	
	public String getItemType() { return itemType; }

}
