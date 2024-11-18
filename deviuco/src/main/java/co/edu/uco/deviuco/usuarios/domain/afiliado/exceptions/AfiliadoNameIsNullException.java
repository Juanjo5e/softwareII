package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoNameIsNullException extends RuleDeviUcoException{

	public AfiliadoNameIsNullException(String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	private static final long serialVersionUID = 1L;
	
	public static final AfiliadoNameIsNullException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("AfiliadoNameIsNullException");
		return new AfiliadoNameIsNullException(userMessage);
	}

}
