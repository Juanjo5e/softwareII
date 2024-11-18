package co.edu.uco.deviuco.usuarios.domain.tipoubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class TipoUbicacionDoesNotExistsException extends RuleDeviUcoException {

    private static final long serialVersionUID = 1L;

    public TipoUbicacionDoesNotExistsException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final TipoUbicacionDoesNotExistsException create(MessageCatalog messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("TipoUbicacionDoesNotExistsException") ;
        return new TipoUbicacionDoesNotExistsException(userMessage);
    }
}
