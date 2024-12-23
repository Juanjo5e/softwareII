package co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class UbicacionTipoUbicacionDoesNotExistsException extends RuleDeviUcoException{

	public UbicacionTipoUbicacionDoesNotExistsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final UbicacionTipoUbicacionDoesNotExistsException create() {
		var userMessage = "El el tipo de ubicacion asociado a la ubicacion no existe...";
		return new UbicacionTipoUbicacionDoesNotExistsException(userMessage);
	}

}
