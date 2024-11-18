package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoCorreoYaExisteException extends RuleDeviUcoException {

    private static final long serialVersionUID = 1L;

    public AfiliadoCorreoYaExisteException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final AfiliadoCorreoYaExisteException create(MessageCatalog messageCatalog) {
    	var userMessage = messageCatalog.getMessageOrDefault("AfiliadoCorreoYaExisteException");
        return new AfiliadoCorreoYaExisteException(userMessage);
    }
}
