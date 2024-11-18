package co.edu.uco.deviuco.usuarios.crosscutting.exception;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

public final class DomainDeviUcoException extends DeviUcoException {
    
	private static final long serialVersionUID = 1L;

	public DomainDeviUcoException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.APPLICATION);
	}
	
	public static final DomainDeviUcoException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new DomainDeviUcoException(userMessage, technicalMessage, rootException);
	}
	
	public static final DomainDeviUcoException create(final String userMessage) {
		return new DomainDeviUcoException(userMessage, userMessage, new Exception());
	}
	
	public static final DomainDeviUcoException create(final String userMessage, final String technicalMessage) {
		return new DomainDeviUcoException(userMessage, technicalMessage, new Exception());
	}

}
