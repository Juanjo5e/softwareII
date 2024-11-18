package co.edu.uco.deviuco.usuarios.domain.sede.exceptions;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class SedeDoesNotExistsException extends RuleDeviUcoException {

	private static final long serialVersionUID = 1L;

	public SedeDoesNotExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final SedeDoesNotExistsException create() {
		var userMessage = "La sede no puede er el valor por defecto";
		return new SedeDoesNotExistsException(userMessage);
	}

}
