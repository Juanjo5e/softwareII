package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;
import co.edu.uco.deviuco.usuarios.application.primaryports.dto.UbicacionDTO;

public class UbicacionResponse extends Response<UbicacionDTO>{
	
	public UbicacionResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
