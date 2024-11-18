package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoIsBeginUsedException extends RuleDeviUcoException
{

	public AfiliadoIsBeginUsedException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	public static final AfiliadoIsBeginUsedException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("AfiliadoIsBeginUsedException");
		return new AfiliadoIsBeginUsedException(userMessage);
	}


}
