package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoPinFormatoIncorrectoException extends RuleDeviUcoException {

	 private static final long serialVersionUID = 1L;

	    public AfiliadoPinFormatoIncorrectoException(String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static final AfiliadoPinFormatoIncorrectoException create(MessageCatalog messageCatalog) {
	        var userMessage = messageCatalog.getMessage("AfiliadoPinFormatoIncorrectoException");
	        return new AfiliadoPinFormatoIncorrectoException(userMessage);
	    }
}
