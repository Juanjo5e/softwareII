package co.edu.uco.deviuco.usuarios.domain.tipoidentificacion.exceptions;
import co.edu.uco.deviuco.usuarios.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;
public class TipoIdentificacionIdIsNullException  extends RuleDeviUcoException{

	private static final long serialVersionUID = 1L;

	public TipoIdentificacionIdIsNullException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final TipoIdentificacionIdIsNullException create(MessageCatalog messageCatalog) {
		var userMessage =messageCatalog.getMessageOrDefault("TipoIdentificacionIdIsNullException");
		return new TipoIdentificacionIdIsNullException(userMessage);
	}

}
