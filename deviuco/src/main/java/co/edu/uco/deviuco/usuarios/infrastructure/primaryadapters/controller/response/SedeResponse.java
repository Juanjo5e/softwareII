package co.edu.uco.deviuco.usuarios.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.edu.uco.deviuco.usuarios.application.primaryports.dto.RetrieveSedeDTO;


public class SedeResponse extends Response<RetrieveSedeDTO>{
	
	public SedeResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}