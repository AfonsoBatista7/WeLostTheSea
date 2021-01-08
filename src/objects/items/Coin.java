package objects.items;

import objects.ItemClass;

public class Coin extends ItemClass {
	private static final String TYPE = "Coin",
								DESCRIPTION = "A, sometimes valuable item, you can used it as a form of payment to optime other items";
	private static final double PRICE = 10;
	
	private static final double PRICE = 10.0;
	
	public Coin() {
		super(TYPE, DESCRIPTION, PRICE);
	}
}
