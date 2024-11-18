package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoCorreoEsNuloException extends RuleDeviUcoException {

    private static final long serialVersionUID = 1L;

    public AfiliadoCorreoEsNuloException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final AfiliadoCorreoEsNuloException create(MessageCatalog messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("AfiliadoCorreoEsNuloException");
        return new AfiliadoCorreoEsNuloException(userMessage);
    }
}
