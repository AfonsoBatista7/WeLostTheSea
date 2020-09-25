package entety.exceptions;

import entety.Entety;

public class ObjectOccupiedException extends RuntimeException {
	
	/**
	 * Someone is already using the object.
	 */
	private static final long serialVersionUID = 5109837651762448249L;
	private Entety entety;
	
	public ObjectOccupiedException (Entety entety) {
		super();
		this.entety = entety;
	}
	
	public Entety getEntety() { return entety; }
}
