package co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class TipoIdentificacionDoesNotExistsException extends RuleDeviUcoException {

	private static final long serialVersionUID = 1L;

	public TipoIdentificacionDoesNotExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final TipoIdentificacionDoesNotExistsException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("TipoIdentificacionDoesNotExistsException");
		return new TipoIdentificacionDoesNotExistsException(userMessage);
	}


}
