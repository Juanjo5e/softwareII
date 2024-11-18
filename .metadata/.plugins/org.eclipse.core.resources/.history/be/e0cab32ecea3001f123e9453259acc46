package co.edu.uco.deviuco.usuarios.domain.sede.exceptions;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class SedeIdIsNullException extends RuleDeviUcoException {

	private static final long serialVersionUID = 1L;

	public SedeIdIsNullException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final SedeIdIsNullException create() {
		var userMessage = "El Id de la Sede no puede ser nulo";
		return new SedeIdIsNullException(userMessage);
	}

}
