package co.edu.uco.deviuco.usuarios.domain.ubicacion.exceptions;

import co.edu.uco.deviuco.usuarios.crosscutting.exception.RuleDeviUcoException;

public class UbicacionNameLenghtIsNotValidException extends RuleDeviUcoException{

	public UbicacionNameLenghtIsNotValidException(String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	private static final long serialVersionUID = 1L;
	
	
	public static final UbicacionNameLenghtIsNotValidException create() {
		var userMessage = "El tamaño del nombre de la ubicacion no es correcto...";
		return new UbicacionNameLenghtIsNotValidException(userMessage);
	}


}
