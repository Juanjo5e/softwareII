package co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class UbicacionNameIsEqualsException extends RuleDeviUcoException {

	public UbicacionNameIsEqualsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final UbicacionNameIsEqualsException create() {
		var userMessage = "Este nombre ya esta asociado a una ubicacion...";
		return new UbicacionNameIsEqualsException(userMessage);
	}

}
