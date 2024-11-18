package co.edu.uco.deviuco.usuarios.crosscutting.exception;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

public final class DtoDeviUcoException extends DeviUcoException {
    
    private static final long serialVersionUID = 1L;

    public DtoDeviUcoException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.DTO);
	}
	
	public static final DtoDeviUcoException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new DtoDeviUcoException(userMessage, technicalMessage, rootException);
	}
	
	public static final DtoDeviUcoException create(final String userMessage) {
		return new DtoDeviUcoException(userMessage, userMessage, new Exception());
	}
	
	public static final DtoDeviUcoException create(final String userMessage, final String technicalMessage) {
		return new DtoDeviUcoException(userMessage, technicalMessage, new Exception());
	}

}
