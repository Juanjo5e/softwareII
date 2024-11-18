package co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.exceptions;
import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class TipoIdentificacionIdIsDefaultValueException extends RuleDeviUcoException{

	private static final long serialVersionUID = 1L;

	public TipoIdentificacionIdIsDefaultValueException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final TipoIdentificacionIdIsDefaultValueException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("TipoIdentificacionIdIsDefaultValueException");
		return new TipoIdentificacionIdIsDefaultValueException(userMessage);
	}

}
