package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;
import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetrieveTipoUbicacionDTO;

public class TipoUbicacionResponse extends Response<RetrieveTipoUbicacionDTO>{
	
	public TipoUbicacionResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}