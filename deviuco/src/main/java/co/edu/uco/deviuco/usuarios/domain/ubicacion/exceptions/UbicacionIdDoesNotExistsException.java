package co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public final class UbicacionIdDoesNotExistsException extends RuleDeviUcoException {

	public UbicacionIdDoesNotExistsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final UbicacionIdDoesNotExistsException create(MessageCatalog messageCatalog ) {
		var userMessage = messageCatalog.getMessageOrDefault("UbicacionIdDoesNotExistsException");
		return new UbicacionIdDoesNotExistsException(userMessage);
	}

}
