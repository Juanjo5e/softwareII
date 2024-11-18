package co.edu.uco.deviuco.usuarios.crosscutting.exception;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

public class RepositoryDeviUcoException extends DeviUcoException {
    
	private static final long serialVersionUID = 1L;

	public RepositoryDeviUcoException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.CROSSCUTING);
	}
	
	public static final RepositoryDeviUcoException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new RepositoryDeviUcoException(userMessage, technicalMessage, rootException);
	}
	
	public static final RepositoryDeviUcoException create(final String userMessage) {
		return new RepositoryDeviUcoException(userMessage, userMessage, new Exception());
	}
	
	public static final RepositoryDeviUcoException create(final String userMessage, final String technicalMessage) {
		return new RepositoryDeviUcoException(userMessage, technicalMessage, new Exception());
	}

}
