package co.edu.uco.deviuco.usuarios.domain.afiliado.exceptions;

import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class AfiliadoIdDoesExistsException extends RuleDeviUcoException {
    private static final long serialVersionUID = 1L;
    
    private AfiliadoIdDoesExistsException(String technicalMessage, String userMessage, Exception rootException) {
        super(technicalMessage, userMessage, rootException);
    }
    
    public static final AfiliadoIdDoesExistsException create(MessageCatalog messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("AfiliadoIdDoesExistsException");
        return new AfiliadoIdDoesExistsException(userMessage, userMessage, new Exception());
    }
} 