package co.edu.uco.deviuco.usuarios.application.primaryports.dto;


import java.util.UUID;

import co.edu.uco.deviuco.usuarios.crosscutting.helpers.TextHelper;
import co.edu.uco.deviuco.usuarios.crosscutting.helpers.UUIDHelper;


public class DepartamentoDTO {
	private UUID id;
	private String nombre;
	
	public DepartamentoDTO() {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
	}
	
	
	
	public DepartamentoDTO(UUID id, String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static DepartamentoDTO create () {
		return new DepartamentoDTO();
		
	}
	public static DepartamentoDTO create(UUID id, String nombre) {
		return new DepartamentoDTO(id, nombre);
		
	}
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}	

}