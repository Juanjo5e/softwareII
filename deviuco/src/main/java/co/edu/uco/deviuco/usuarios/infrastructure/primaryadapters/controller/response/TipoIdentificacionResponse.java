package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetriveTipoIdentificacionDTO;

public class TipoIdentificacionResponse extends Response<RetriveTipoIdentificacionDTO>{
	
	public TipoIdentificacionResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}