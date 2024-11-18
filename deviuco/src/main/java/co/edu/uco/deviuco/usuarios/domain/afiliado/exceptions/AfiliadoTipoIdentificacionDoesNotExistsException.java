package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;


import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoTipoIdentificacionDoesNotExistsException extends RuleDeviUcoException{
	
	
	public AfiliadoTipoIdentificacionDoesNotExistsException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final AfiliadoTipoIdentificacionDoesNotExistsException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("AfiliadoTipoIdentificacionDoesNotExistsException");
		return new AfiliadoTipoIdentificacionDoesNotExistsException(userMessage);
	}

}
