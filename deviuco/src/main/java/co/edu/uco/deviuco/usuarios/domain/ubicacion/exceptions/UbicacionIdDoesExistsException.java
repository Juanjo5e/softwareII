package co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public final class UbicacionIdDoesExistsException extends RuleDeviUcoException {

	private static final long serialVersionUID = 1L;

	public UbicacionIdDoesExistsException(String userMessage) {
		super(userMessage, userMessage, new Exception());

	}
	
	public static final UbicacionIdDoesExistsException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("UbicacionIdDoesExistsException");
		return new UbicacionIdDoesExistsException(userMessage);
	}

}
