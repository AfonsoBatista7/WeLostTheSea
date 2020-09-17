package entety;

import gameSystem.Actions;
import locations.Location;

public interface Entety {

	/**
	 * @return Player name.
	 */
	String getName();
	
	/**
	 * @return Player location.
	 */
	Location getLocation();
	
	/**
	 * Teleport the player to a new location
	 * @param newLocation
	 */
	void setLocation(Location newLocation);
	
	int getBalance();
	
	/**
	 * Buy something.
	 * @param price - Money you have to pay.
	 */
	void buy(int price);
	
	/**
	 * Sell something.
	 * @param price - Money you have to gain.
	 */
	void sell(int price);
	
	int getAction();
	
	void action(Actions action);
	
}