package co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class UbicacionSedeDoesNotExistsException extends RuleDeviUcoException{

	public UbicacionSedeDoesNotExistsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final UbicacionSedeDoesNotExistsException create() {
		var userMessage = "La sede especificada no existe en el sistema...";
		return new UbicacionSedeDoesNotExistsException(userMessage);
	}

}
