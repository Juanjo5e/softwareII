	package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoPinEsNuloException extends RuleDeviUcoException {

	 private static final long serialVersionUID = 1L;

	    public AfiliadoPinEsNuloException(String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static final AfiliadoPinEsNuloException create(MessageCatalog messageCatalog) {
	        var userMessage = messageCatalog.getMessage("AfiliadoPinEsNuloException");
	        return new AfiliadoPinEsNuloException(userMessage);
	    }
}
