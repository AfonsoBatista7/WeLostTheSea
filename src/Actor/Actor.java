package Actor;

import locations.Location;

public interface Actor {

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
	
}
