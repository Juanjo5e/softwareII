package co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class UbicacionNameIsEmptyException extends RuleDeviUcoException {

	public UbicacionNameIsEmptyException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final UbicacionNameIsEmptyException create( MessageCatalog messageCatalog) {
		var userMessage = "El nombre de la Ubicacion no puede estar vacio...";
		return new UbicacionNameIsEmptyException(userMessage);
	}

}
