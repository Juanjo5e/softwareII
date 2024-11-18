package co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class UbicacionNameFormatIsNotValidException extends RuleDeviUcoException{

	public UbicacionNameFormatIsNotValidException(String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	private static final long serialVersionUID = 1L;
	
	public static final UbicacionNameFormatIsNotValidException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("UbicacionNameFormatIsNotValidException");
		return new UbicacionNameFormatIsNotValidException(userMessage);
	}


}
