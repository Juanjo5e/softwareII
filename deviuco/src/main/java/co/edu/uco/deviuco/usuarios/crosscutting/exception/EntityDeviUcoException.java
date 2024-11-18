package co.edu.uco.deviuco.usuarios.crosscutting.exception;
import co.edu.uco.deviuco.usuarios.crosscutting.exception.enums.Layer;

public final class EntityDeviUcoException extends DeviUcoException {
    
	private static final long serialVersionUID = 1L;

	public EntityDeviUcoException(final String userMessage, final String technicalMessage, final Exception rootException){
		super(userMessage, technicalMessage, rootException, Layer.ENTITY);
	}
	
	public static final EntityDeviUcoException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new EntityDeviUcoException(userMessage, technicalMessage, rootException);
	}
	
	public static final EntityDeviUcoException create(final String userMessage) {
		return new EntityDeviUcoException(userMessage, userMessage, new Exception());
	}
	
	public static final EntityDeviUcoException create(final String userMessage, final String technicalMessage) {
		return new EntityDeviUcoException(userMessage, technicalMessage, new Exception());
	}

}