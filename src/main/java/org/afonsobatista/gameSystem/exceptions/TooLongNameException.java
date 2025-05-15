package org.afonsobatista.gameSystem.exceptions;

/**
 * The Player name has more than 22 characters.
 * @author Afonso Batista
 */
public class TooLongNameException extends RuntimeException{

	private static final long serialVersionUID = 1057722473475516911L;
	public TooLongNameException() {
		super();
	}
}
