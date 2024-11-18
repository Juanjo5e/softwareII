package co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class UbicacionIsBeginUsedException extends RuleDeviUcoException{

	public UbicacionIsBeginUsedException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final UbicacionIsBeginUsedException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("UbicacionIsBeginUsedException");
		return new UbicacionIsBeginUsedException(userMessage);
	}

}
