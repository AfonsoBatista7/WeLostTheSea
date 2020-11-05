package entety.exceptions;

import entety.Entity;

/**
 * @author Afonso Batista
 *
 */
public class ObjectOccupiedException extends RuntimeException {
	
	/**
	 * Someone is already using the object.
	 */
	private static final long serialVersionUID = 5109837651762448249L;
	private Entity entety;
	
	public ObjectOccupiedException (Entity entety) {
		super();
		this.entety = entety;
	}
	
	public Entity getEntety() { return entety; }
}
