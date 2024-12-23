package co.edu.uco.deviuco.usuarios.crosscutting.exception;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

public class GeneralDeviUcoException extends DeviUcoException {

	private static final long serialVersionUID = 1L;

	public GeneralDeviUcoException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.GENERAL);
	}
	
	public static final GeneralDeviUcoException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new GeneralDeviUcoException(userMessage, technicalMessage, rootException);
	}
	
	public static final GeneralDeviUcoException create(final String userMessage) {
		return new GeneralDeviUcoException(userMessage, userMessage, new Exception());
	}
	
	public static final GeneralDeviUcoException create(final String userMessage, final String technicalMessage) {
		return new GeneralDeviUcoException(userMessage, technicalMessage, new Exception());
	}

}
