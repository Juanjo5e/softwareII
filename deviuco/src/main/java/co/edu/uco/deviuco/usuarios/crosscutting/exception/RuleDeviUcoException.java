package co.edu.uco.deviuco.usuarios.crosscutting.exception;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

public class RuleDeviUcoException extends DeviUcoException {
    
	private static final long serialVersionUID = 1L;

	public RuleDeviUcoException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.RULE);
	}
	
	public static final RuleDeviUcoException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new RuleDeviUcoException(userMessage, technicalMessage, rootException);
	}
	
	public static final RuleDeviUcoException create(final String userMessage) {
		return new RuleDeviUcoException(userMessage, userMessage, new Exception());
	}
	
	public static final RuleDeviUcoException create(final String userMessage, final String technicalMessage) {
		return new RuleDeviUcoException(userMessage, technicalMessage, new Exception());
	}

}
