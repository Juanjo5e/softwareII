package co.edu.uco.deviuco.usuarios.crosscutting.exception;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

public final class UseCaseDeviUcoException extends DeviUcoException {
    
	private static final long serialVersionUID = 1L;

	public UseCaseDeviUcoException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.USECASE);
	}
	
	public static final UseCaseDeviUcoException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new UseCaseDeviUcoException(userMessage, technicalMessage, rootException);
	}
	
	public static final UseCaseDeviUcoException create(final String userMessage) {
		return new UseCaseDeviUcoException(userMessage, userMessage, new Exception());
	}
	
	public static final UseCaseDeviUcoException create(final String userMessage, final String technicalMessage) {
		return new UseCaseDeviUcoException(userMessage, technicalMessage, new Exception());
	}

}
