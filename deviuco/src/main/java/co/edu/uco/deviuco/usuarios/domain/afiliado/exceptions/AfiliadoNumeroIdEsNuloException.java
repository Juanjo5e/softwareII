package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoNumeroIdEsNuloException extends RuleDeviUcoException {

	private static final long serialVersionUID = 1L;

    public AfiliadoNumeroIdEsNuloException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final AfiliadoNumeroIdEsNuloException create(MessageCatalog messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("AfiliadoNameIsNullException");
        return new AfiliadoNumeroIdEsNuloException(userMessage);
    }
}
