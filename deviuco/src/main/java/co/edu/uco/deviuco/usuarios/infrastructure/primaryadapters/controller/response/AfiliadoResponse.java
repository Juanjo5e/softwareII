package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.AfiliadoDTO;


public class AfiliadoResponse extends Response<AfiliadoDTO>{
	
	public AfiliadoResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
