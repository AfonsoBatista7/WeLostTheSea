package locations.exceptions;

public class NoExitException extends RuntimeException{

	/**
	 * This Location does't have an exit for that direction.
	 */
	private static final long serialVersionUID = 450651929475594990L;
	public NoExitException() {
		super();
	}
}
