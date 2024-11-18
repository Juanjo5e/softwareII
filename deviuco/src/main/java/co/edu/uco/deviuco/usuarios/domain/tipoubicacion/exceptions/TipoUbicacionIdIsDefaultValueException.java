package co.edu.uco.deviuco.usuarios.domain.tipoubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class TipoUbicacionIdIsDefaultValueException extends RuleDeviUcoException {

    private static final long serialVersionUID = 1L;

    public TipoUbicacionIdIsDefaultValueException(String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final TipoUbicacionIdIsDefaultValueException create(MessageCatalog messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("TipoUbicacionIdIsDefaultValueException");
        return new TipoUbicacionIdIsDefaultValueException(userMessage);
    }
}
