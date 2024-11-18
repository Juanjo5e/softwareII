package co.edu.uco.deviuco.usuarios.crosscutting.exception;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

public final class ApplicationDeviUcoException extends DeviUcoException {
    
	private static final long serialVersionUID = 1L;

	public ApplicationDeviUcoException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.DOMAIN);
	}
	
	public static final ApplicationDeviUcoException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new ApplicationDeviUcoException(userMessage, technicalMessage, rootException);
	}
	
	public static final ApplicationDeviUcoException create(final String userMessage) {
		return new ApplicationDeviUcoException(userMessage, userMessage, new Exception());
	}
	
	public static final ApplicationDeviUcoException create(final String userMessage, final String technicalMessage) {
		return new ApplicationDeviUcoException(userMessage, technicalMessage, new Exception());
	}

}
