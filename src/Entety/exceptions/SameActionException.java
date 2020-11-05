package entety.exceptions;

/**
 * @author Afonso Batista
 *
 */
public class SameActionException extends RuntimeException {

	/**
	 * If is already doing the same action.
	 */
	private static final long serialVersionUID = -5388969960058373309L;
	public SameActionException() { super(); }

}
