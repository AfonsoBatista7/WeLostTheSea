package org.afonsobatista.locations.exceptions;

public class EntityNotInLocationException extends RuntimeException {
	/**
	 * This Location does't have an exit for that direction.
	 */
	private static final long serialVersionUID = 450651929475594990L;
	public EntityNotInLocationException() {
		super();
	}
}
