package co.edu.uco.deviuco.usuarios.domain.sede.exceptions;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;
public class SedeIdIsDefaultValueException extends RuleDeviUcoException {

	private static final long serialVersionUID = 1L;

	public SedeIdIsDefaultValueException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final SedeIdIsDefaultValueException create() {
		var userMessage = "La Sede no existe";
		return new SedeIdIsDefaultValueException(userMessage);
	}

}
