package co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class UbicacionNameIsNullException extends RuleDeviUcoException{

	public UbicacionNameIsNullException(String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	private static final long serialVersionUID = 1L;
	
	public static final UbicacionNameIsNullException create() {
		var userMessage = "El nombre de la ubicacion no puede ser nulo...";
		return new UbicacionNameIsNullException(userMessage);
	}

}
