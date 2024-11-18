package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoIdentificacionDuplicadaException extends RuleDeviUcoException {

	 private static final long serialVersionUID = 1L;

	    public AfiliadoIdentificacionDuplicadaException(String userMessage) {
	        super(userMessage, userMessage, new Exception());
	    }

	    public static final AfiliadoIdentificacionDuplicadaException create(MessageCatalog messageCatalog) {
	        var userMessage =  messageCatalog.getMessageOrDefault("AfiliadoIdentificacionDuplicadaException");
	        return new AfiliadoIdentificacionDuplicadaException(userMessage);
	    }
}
