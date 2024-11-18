package co.edu.uco.deviuco.usuarios.crosscutting.exception;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

public final class CrosscuttingDeviUcoException extends DeviUcoException {
    
	private static final long serialVersionUID = 1L;

	public CrosscuttingDeviUcoException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.CROSSCUTING);
	}
	public CrosscuttingDeviUcoException(final String userMessage, final String technicalMessage){
		super(userMessage, technicalMessage);
	}
	
	public static final CrosscuttingDeviUcoException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new CrosscuttingDeviUcoException(userMessage, technicalMessage, rootException);
	}
	
	public static final CrosscuttingDeviUcoException create(final String userMessage) {
		return new CrosscuttingDeviUcoException(userMessage, userMessage, new Exception());
	}
	
	public static final CrosscuttingDeviUcoException create(final String userMessage, final String technicalMessage) {
		return new CrosscuttingDeviUcoException(userMessage, technicalMessage, new Exception());
	}

}
