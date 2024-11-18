package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoTelefonoFormatoIncorrectoException extends RuleDeviUcoException {

	 private static final long serialVersionUID = 1L;

	    public AfiliadoTelefonoFormatoIncorrectoException(String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static final AfiliadoTelefonoFormatoIncorrectoException create(MessageCatalog messageCatalog) {
	        var userMessage = messageCatalog.getMessageOrDefault("AfiliadoTelefonoFormatoIncorrectoException");
	        return new AfiliadoTelefonoFormatoIncorrectoException(userMessage);
	    }
}